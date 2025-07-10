package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            BookRepository br = new BookRepository();
            ResultSet rs = br.showBooks();

            out.println("<html><head><title>Books</title></head><body>");
            out.println("<table border='1' cellpadding='5' cellspacing='0' width='100%'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Sr No</th>");
            out.println("<th>Name</th>");
            out.println("<th>Author</th>");
            out.println("<th>Progress</th>");
            out.println("<th>Edit</th>");
            out.println("<th>Delete</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            int srNo = 1;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String progress = rs.getString("progress");

                out.println("<tr>");
                out.println("<td>" + srNo++ + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + author + "</td>");
                out.println("<td>" + progress + "</td>");
                out.println("<td><a href='edit?id=" + id + "'>Edit</a></td>");
                out.println("<td><a href='delete?id=" + id + "'>Delete</a></td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("</body></html>");

        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

    }
}
