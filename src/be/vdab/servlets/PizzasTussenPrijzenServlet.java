package be.vdab.servlets;

import be.vdab.dao.PizzaDAO;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Samuel Engelen on 28/04/2015.
 */
@WebServlet(name = "PizzasTussenPrijzenServlet", urlPatterns = "/pizzas/tussenprijzen.htm")
public class PizzasTussenPrijzenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/pizzastussenprijzen.jsp";
    private final transient PizzaDAO pizzaDAO = new PizzaDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getQueryString() != null) {
            Map<String, String> fouten = new HashMap<>();
            BigDecimal van = null;
            try {
                van = new BigDecimal(request.getParameter("van"));
            } catch (NumberFormatException e) {
                fouten.put("van", "tik een getal");
            }
            BigDecimal tot = null;
            try {
                tot = new BigDecimal(request.getParameter("tot"));
            } catch (NumberFormatException e) {
                fouten.put("tot", "tik een getal");
            }
            if (fouten.isEmpty()) {
                request.setAttribute("pizzas", pizzaDAO.findByPrijsBetween(van, tot));
            } else {
                request.setAttribute("fouten", fouten);
            }
        }
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    @Resource(name = PizzaDAO.JNDI_NAME)
    void setDataSource(DataSource dataSource) {
        pizzaDAO.setDataSource(dataSource);
    }
}
