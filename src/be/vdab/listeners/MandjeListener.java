package be.vdab.listeners; /**
 * Created by Samuel Engelen on 5/05/2015.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.concurrent.atomic.AtomicInteger;

//@WebListener()
public class MandjeListener implements ServletContextListener, HttpSessionAttributeListener {
    private static final String MANDJE = "mandje";
    private static final String AANTAL_MANDJES = "aantalMandjes";

    // Public constructor is required by servlet spec
    public MandjeListener() {}

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------

    @Override
    public void contextInitialized(ServletContextEvent sce) {
      sce.getServletContext().setAttribute(AANTAL_MANDJES, new AtomicInteger());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------


    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        if (MANDJE.equals(sbe.getName())) {
            ((AtomicInteger) sbe.getSession().getServletContext().getAttribute(AANTAL_MANDJES)).getAndIncrement();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        if (MANDJE.equals(sbe.getName())) {
            ((AtomicInteger) sbe.getSession().getServletContext().getAttribute(AANTAL_MANDJES)).getAndDecrement();
        }
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
