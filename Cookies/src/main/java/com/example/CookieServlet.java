package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String color = req.getParameter("color");

        Cookie cookie1 = new Cookie("name",name);
        Cookie cookie2 = new Cookie("password",password);
        Cookie cookie3 = new Cookie("color",color);
        //Set age
        cookie1.setMaxAge(3600);
        cookie2.setMaxAge(3600);
        cookie3.setMaxAge(1);
        //add cookies
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);

        resp.sendRedirect("cookie");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie cookie :cookies){
                out.println("<h1>USer "+cookie.getName()+":"+cookie.getValue());
            }
        }else {
            out.println("No cookies found");
        }
    }
}
