package com.example;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/generic")
public class GenericServlet extends javax.servlet.GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpServletRequest httpReq = (HttpServletRequest) req;
        String url = httpReq.getRequestURL().toString();
        out.println("URL: " + url);
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String op = req.getParameter("op");
        out.println("<html><body>");
        out.println("<h2>Multiplication & Division</h2>");
        out.println("<form method='get'>");
        out.println("Number 1: <input type='number' name='num1' required><br><br>");
        out.println("Number 2: <input type='number' name='num2' required><br><br>");
        out.println("Operation: ");
        out.println("<select name='op'>");
        out.println("<option value='mul'>Multiply</option>");
        out.println("<option value='div'>Divide</option>");
        out.println("</select><br><br>");
        out.println("<input type='submit' value='Calculate'>");
        out.println("</form>");
        if(num1!=null && num2!=null && op!=null){
            int result;
            int num_1 = Integer.parseInt(num1);
            int num_2 = Integer.parseInt(num2);
            if("mul".equals(op)){
                result= num_1* num_2;
            }else{
                result=num_1/num_2;
            }
            out.println("<h3>Result: " + result + "</h3>");
        }
        out.println("</body></html>");
    }
}
