package com.example;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String progress = req.getParameter("progress");
        BookRepository br = new BookRepository();
        int result = br.addBook(name, author, progress);
        if(result!=0){
            System.out.println("Inserted");
        }
        res.sendRedirect("index.html");
    }

    @Override
    public void init() {
        System.out.println("INIT CALLING");
        BookRepository.DatabaseInitializer DI = new BookRepository().new DatabaseInitializer();
        try {
            DI.initialize();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
