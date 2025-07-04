package com.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/http")
public class HttpServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        StringBuffer url = req.getRequestURL();
        out.println("URL:"+url);

        String num1Str = req.getParameter("num1");
        String num2Str = req.getParameter("num2");
        String operation = req.getParameter("op");

        out.println("<html><body>");
        out.println("<h2>Addition And Subtraction</h2>");
        out.println("<form method='get'>");
        out.println("Number 1: <input type='number' name='num1' required><br><br>");
        out.println("Number 2: <input type='number' name='num2' required><br><br>");
        out.println("Operation: ");
        out.println("<select name='op'>");
        out.println("<option value='add'>Add</option>");
        out.println("<option value='sub'>Subtract</option>");
        out.println("</select><br><br>");
        out.println("<input type='submit' value='Calculate'>");
        out.println("</form>");

        if (num1Str != null && num2Str != null && operation != null) {

            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);
            int result;

            if ("add".equals(operation)) {
                result = num1 + num2;
                out.println("<h3>Result: "+ result + "</h3>");
            } else {
                result = num1 - num2;
                out.println("<h3>Result: "+ result + "</h3>");
            }
        }

        out.println("</body></html>");
    }
}
