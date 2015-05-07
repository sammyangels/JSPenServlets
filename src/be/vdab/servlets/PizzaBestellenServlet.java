package be.vdab.servlets;

import be.vdab.dao.PizzaDAO;
import be.vdab.entities.Pizza;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Samuel Engelen on 29/04/2015.
 */
@WebServlet(name = "PizzaBestellenServlet", urlPatterns = "/pizzas/bestellen.htm")
public class PizzaBestellenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/pizzabestellen.jsp";
    private static final String MANDJE = "mandje";
    private final transient PizzaDAO pizzaDAO = new PizzaDAO();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterValues("id") != null) {
            HttpSession session = request.getSession();
            @SuppressWarnings("unchecked")
            Set<Long> mandje = (Set<Long>) session.getAttribute(MANDJE);
            if (mandje == null) {
                mandje = new LinkedHashSet<>();
            }
            for (String id : request.getParameterValues("id")) {
                mandje.add(Long.parseLong(id));
            }
            session.setAttribute(MANDJE, mandje);
        }
        response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("allePizzas", pizzaDAO.findAll());
        HttpSession session = request.getSession(false);
        if (session != null) {
            @SuppressWarnings("unchecked")
            Set<Long> mandje = (Set<Long>) session.getAttribute(MANDJE);
            if (mandje != null) {
                List<Pizza> pizzasInMandje = new ArrayList<>();
                for (long id : mandje) {
                    pizzasInMandje.add(pizzaDAO.read(id));
                }
                request.setAttribute("pizzasInMandje", pizzasInMandje);
            }
        }
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    @Resource(name = PizzaDAO.JNDI_NAME)
    void setDataSource(DataSource dataSource) {
        pizzaDAO.setDataSource(dataSource);
    }
}
