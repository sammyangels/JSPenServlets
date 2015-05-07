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

/**
 * Created by Samuel Engelen on 28/04/2015.
 */
@WebServlet(name = "PizzaDetailServlet", urlPatterns = "/pizzas/detail.htm")
public class PizzaDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/pizzadetail.jsp";
    private final transient PizzaDAO pizzaDAO = new PizzaDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("pizza", pizzaDAO.read(Long.parseLong(request.getParameter("id"))));
        } catch (NumberFormatException e) {
            request.setAttribute("fout", "Nummer niet correct");
        }
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    @Resource(name = PizzaDAO.JNDI_NAME)
    void setDataSource(DataSource dataSource) {
        pizzaDAO.setDataSource(dataSource);
    }
}
