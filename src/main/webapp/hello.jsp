<%@ page import="links.Link" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<h1>Hello world</h1>


<%!
    String message = "Ala ma kota";
    Link link = new Link("https://www.reddit.com", "reddit");
    Integer age = 15;%>


<h1>
    <%= message %>
    <%= link.getText() %>
</h1>


<%
    List<String> list = new ArrayList<>();
    list.add("Dupa 123");
    list.add("123");
    message = "test";
    out.println(list);
%>

<% if (age > 18) {%>
<h2> jesteś młodociany </h2>
<% } else { %>
<h2> jesteś gówniarzem </h2>
<% } %>

<%
    if (age > 21) {
        out.println("have fun");
    } else {
        out.println("nici z alkoholu");
    }
%>