package be.vdab.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Samuel Engelen on 5/05/2015.
 */
//@WebFilter(filterName = "ServletFilter", urlPatterns = "*.htm")
public class ServletFilter implements Filter {
    private String encoding;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
    }

}
