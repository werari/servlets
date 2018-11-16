<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Hello World</h1>
${message}<br/>
<c:out value="${message}"/><br/>
<c:forEach items="${names}" var="name">
    ${name}<br/>
</c:forEach>