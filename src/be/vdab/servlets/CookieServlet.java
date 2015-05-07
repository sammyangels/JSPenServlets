package be.vdab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Samuel Engelen on 29/04/2015.
 */
@WebServlet(name = "CookieServlet", urlPatterns = "/cookies.htm")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/cookies.jsp";
    private static final int COOKIE_MAXIMUM_LEEFTIJD = 60 /* seconden*/ * 30 /* minuten */;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("naam", URLEncoder.encode(request.getParameter("naam"), "UTF-8"));
        cookie.setMaxAge(COOKIE_MAXIMUM_LEEFTIJD);
        response.addCookie(cookie);
        response.sendRedirect(request.getRequestURI());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locale = request.getParameter("locale");
        if (locale != null) {
            request.getSession().setAttribute("locale", locale);
        }

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("naam".equals(cookie.getName())) {
                    request.setAttribute("naam", URLDecoder.decode(cookie.getValue(), "UTF-8"));
                    break;
                }
            }
        }
        request.getRequestDispatcher(VIEW).forward(request, response);
    }
}
