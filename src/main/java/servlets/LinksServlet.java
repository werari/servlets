package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html");
        writer.println("<div>");
        writer.println("<a href=\"https://www.yahoo.com/?guccounter=1\">yahoo</a>");
        writer.println("<br/>");
        writer.println("<a href=\"https://github.com/\">github</a>");
        writer.println("<br/>");
        writer.println("<a href=\"https://www.codewars.com/users/sign_in\">CodeWar</a>");
        writer.println("</div>");
    }
}
