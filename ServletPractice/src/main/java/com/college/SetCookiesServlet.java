package com.college; 


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class SetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie userCookie = new Cookie("username", "Hello_User");
        userCookie.setMaxAge(3600); // 1 hour
        resp.addCookie(userCookie);
        
        resp.setContentType("text/html");
        resp.getWriter().println("Cookie has been set. <a href='getcookie'>View Cookie</a>");
    }
}