package be.vdab.servlets;

import be.vdab.dao.PizzaDAO;
import be.vdab.entities.Pizza;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Samuel Engelen on 22/04/2015.
 */
@WebServlet("/pizzas.htm")
public class PizzasServlet extends HttpServlet {
    private static final long serialVersionUID = 1l;
    private static final String VIEW = "/WEB-INF/JSP/pizzas.jsp";
    private static final String PIZZAS_REQUESTS = "pizzasRequests";
    private final transient PizzaDAO pizzaDAO = new PizzaDAO();

    @Override
    public void init() throws ServletException {
        this.getServletContext().setAttribute(PIZZAS_REQUESTS, new AtomicInteger());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ((AtomicInteger) this.getServletContext().getAttribute(PIZZAS_REQUESTS)).incrementAndGet();
        List<Pizza> pizzas = pizzaDAO.findAll();
        String pizzaFotosPad = this.getServletContext().getRealPath("/pizzafotos");
        Set<Long> pizzaIdsMetFoto = new HashSet<>();
        for (Pizza pizza : pizzas) {
            File file = new File(String.format("%s/%d.jpg", pizzaFotosPad, pizza.getId()));
            if (file.exists()) {
                pizzaIdsMetFoto.add(pizza.getId());
            }
        }
        request.setAttribute("pizzas", pizzas);
        request.setAttribute("pizzaIdsMetFoto", pizzaIdsMetFoto);
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    @Resource(name = PizzaDAO.JNDI_NAME)
    void setDataSource(DataSource dataSource) {
        pizzaDAO.setDataSource(dataSource);
    }
}
