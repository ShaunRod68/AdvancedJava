package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String progress = req.getParameter("progress");
        String id = req.getParameter("id");
        BookRepository br = new BookRepository();
        int result = br.updateBook(id,name, author, progress);
        if(result!=0){
            System.out.println("Inserted");
        }
        res.sendRedirect("index.html");
    }
}
