package il.ac.hit.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by artur on 09/05/2016.
 */
public class SessionListener implements HttpSessionListener {
    private int sessionCount = 0;

    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession( );
        ServletContext application = session.getServletContext( );
        if (application.getAttribute("sessions") == null) {
            application.setAttribute("sessions", new HashSet<HttpSession>( ));
        }
        @SuppressWarnings("unchecked") Set<HttpSession> set = (Set<HttpSession>) application.getAttribute("sessions");
        set.add(session);
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession( );
        ServletContext application = session.getServletContext( );
        @SuppressWarnings("unchecked") Set<HttpSession> set = (HashSet<HttpSession>) application.getAttribute("sessions");
        set.remove(session);
    }

}