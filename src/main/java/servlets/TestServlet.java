package users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("names", Arrays.asList("Jan", "Anna", "ktos"));

        req.setAttribute("message", "Wera ma kota");
        req.getRequestDispatcher("test.jsp").forward(req,resp);
    }
}
