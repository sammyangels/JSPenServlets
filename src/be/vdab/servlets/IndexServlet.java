package be.vdab.servlets;

import be.vdab.entities.Adres;
import be.vdab.entities.Begroeting;
import be.vdab.entities.Persoon;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Samuel Engelen on 21/04/2015.
 */
@WebServlet(urlPatterns = "/index.htm", name = "indexservlet")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/index.jsp";
    private final Persoon zaakvoerder = new Persoon();
    private final AtomicInteger aantalKeerBekeken = new AtomicInteger();  // automatisch op 0 geinitialiseerd
    private static final String INDEX_REQUESTS = "indexRequests";

    @Override
    public void init() throws ServletException {
        ServletContext context = this.getServletContext();
        context.setAttribute(INDEX_REQUESTS, new AtomicInteger());

        zaakvoerder.setVoornaam(context.getInitParameter("voornaam"));
        zaakvoerder.setFamilienaam(context.getInitParameter("familienaam"));
        zaakvoerder.setAantalKinderen(Integer.parseInt(context.getInitParameter("aantalKinderen")));
        zaakvoerder.setGehuwd(Boolean.parseBoolean(context.getInitParameter("gehuwd")));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("aantalPizzasVerkocht", 23000);
        request.setAttribute("nu", Calendar.getInstance().getTime());
        request.setAttribute("aantalKeerBekeken", aantalKeerBekeken.incrementAndGet());
        request.setAttribute("zaakvoerder", zaakvoerder);
        request.setAttribute("begroeting", new Begroeting());
        request.getRequestDispatcher(VIEW).forward(request, response);
        ((AtomicInteger) this.getServletContext().getAttribute(INDEX_REQUESTS)).incrementAndGet();
    }
}
