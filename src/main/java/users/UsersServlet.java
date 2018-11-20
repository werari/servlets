package users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public class UsersServlet extends HttpServlet {
    private UsersService usersService;

    @Override
    public void init() throws ServletException {
        this.usersService = UsersService.instanceOf();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String gender = req.getParameter("gender");
        StringBuilder redirectBuilder = new StringBuilder();
        redirectBuilder.append(req.getContextPath())
                .append(req.getServletPath());


        User user = new User(firstName, lastName, age, gender);
        usersService.save(user);

        resp.sendRedirect(redirectBuilder.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html");


        String errorMessage = req.getParameter("error_message");
        if (errorMessage != null) {
            writer.println("<p style=\" color:red;\" >" + errorMessage + "</p>");
        }
        writer.println("Uzytkownicy: ");
        createCreationForm(writer);
        writer.println("<br>");
        createQueryForm(writer);
        String query = Optional.ofNullable(req.getParameter("q")).orElse(" ");

        List<User> users = usersService.findByQuery(query);

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            writer.println("<a href=\"" + req.getContextPath() + req.getServletPath() + "/" + user.getId() + "\">");
            writer.println("<p>" + user.getFirstName() + " " + user.getLastName() + "</p>");
            writer.println("</a>");
        }

    }

    private void createQueryForm(PrintWriter writer) {
        String creationForm="<form action=\"\" method=\"get\">\n" +
                "    Search: <input type=\"text\" name=\"q\">\n" +
                "    <br>\n" +
                "    <input type=\"submit\">\n" +
                "\n" +
                "</form>";
        writer.println(creationForm);
    }

    private void createCreationForm(PrintWriter writer) {
        String form = "<form action=\"\" method=\"post\">\n" +
                "    firstName: <input type=\"text\" name=\"firstName\">\n" +
                "    <br>\n" +
                "    lastName: <input type=\"text\" name=\"lastName\">\n" +
                "    <br>\n" +
                "    age: <input type=\"number\" name=\"age\">\n" +
                "    <br>\n" +
                "    gender: <input type=\"text\" name=\"gender\">\n" +
                "    <br>\n" +
                "    <input type=\"submit\">\n" +
                "\n" +
                "</form>";
        writer.println(form);
    }
}
