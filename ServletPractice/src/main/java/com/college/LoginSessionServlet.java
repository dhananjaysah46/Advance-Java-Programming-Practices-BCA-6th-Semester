package com.college; // This must match the package folder name

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginSessionServlet extends HttpServlet { // Must match filename
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        
        if("admin".equals(user) && "1234".equals(pass)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", user);
            resp.sendRedirect("dashboard"); 
        } else {
            resp.setContentType("text/html");
            resp.getWriter().println("Login Failed. Use admin/1234");
        }
    }
}