package com.college; 


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class GetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = "Guest";
        Cookie[] cookies = req.getCookies();
        
        if(cookies != null) {
            for(Cookie c : cookies) {
                if(c.getName().equals("username")) {
                    username = c.getValue();
                }
            }
        }
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Stored Cookie Value: " + username + "</h1>");
    }
}