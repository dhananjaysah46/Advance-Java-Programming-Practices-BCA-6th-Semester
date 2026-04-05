
package com.college; 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DashboardSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Use false so a new session isn't created if one doesn't exist
        HttpSession session = req.getSession(false);
        
        if(session == null || session.getAttribute("username") == null) {
            resp.sendRedirect("login.html");
            return;
        }
        
        String user = (String) session.getAttribute("username");
        resp.setContentType("text/html"); // Fixed typo from 'test/html'
        resp.getWriter().println("<h1>Welcome to dashboard, " + user + "</h1>");
        resp.getWriter().println("<br><a href='index.jsp'>Back to Home</a>");
    }
}