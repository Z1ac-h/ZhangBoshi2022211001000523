<%--
  Created by IntelliJ IDEA.
  User: 1234e's'z'x'c'v
  Date: 2024/4/9
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>

<h1>userList</h1>
<table border='1'>
    <tr>
        <td>ID</td>
        <td>Username</td>
        <td>Password</td>
        <td>Email</td>
        <td>Gender</td>
        <td>Birthdate</td>
    </tr>

    <%
        ResultSet rs = (ResultSet) request.getAttribute("rname");
        if (rs==null){
    %>
    <tr>
        <td colspan="7">No data!!!</td>
    </tr>
    <%}else {

        response.setContentType("text/html");
        List<Map<String, Object>> results = (List<Map<String, Object>>) request.getAttribute("resname");
        for (Map<String, Object> row : results) {
    %>
    <tr>
        <td><%=row.get("ID") %></td>
        <td><%=row.get("Username") %></td>
        <td><%=row.get("Password") %></td>
        <td><%=row.get("Email") %></td>
        <td><%=row.get("Gender") %></td>
        <td><%=row.get("Birthdate") %></td>
    </tr>
    <%
                }

        }
    %>

</table>

<%@include file="footer.jsp"%>