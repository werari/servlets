package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
//        writer.println("<h1>Hello world</h1>");
//        writer.println("<h1>Dupa 1234</h1>");
        req.setAttribute("names", Arrays.asList("Jan", "Anna", "ktos"));
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
