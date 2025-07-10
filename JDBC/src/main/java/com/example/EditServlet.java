package com.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String id = req.getParameter("id");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            BookRepository br = new BookRepository();
            ResultSet rs = br.showbook(id); // assumes showbook returns only one book

            if (rs.next()) {
                String name = rs.getString("name");
                String author = rs.getString("author");
                String progress = rs.getString("progress");

                out.println("<html><body>");
                out.println("<h2>Edit Book</h2>");

                out.println("<form action='update' method='get' target='bookFrame'>");
                out.println("<input type='hidden' name='id' value='" + id + "'/>");

                out.println("Book Name:<br>");
                out.println("<input type='text' name='name' value='" + name + "' required><br><br>");

                out.println("Author:<br>");
                out.println("<input type='text' name='author' value='" + author + "' required><br><br>");

                out.println("Progress:<br>");
                out.println("<select name='progress'>");
                for (String option : new String[]{"Not Started", "In Progress", "Done"}) {
                    String selected = option.equals(progress) ? " selected" : "";
                    out.println("<option value='" + option + "'" + selected + ">" + option + "</option>");
                }
                out.println("</select><br><br>");

                out.println("<input type='submit' value='Update Book'>");
                out.println("</form>");

                out.println("<br><a href='index.html' target='_top'>Back</a>");
                out.println("</body></html>");
            } else {
                out.println("<p>Book not found.</p>");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
