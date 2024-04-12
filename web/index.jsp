<%--
  Created by IntelliJ IDEA.
  User: 1234e's'z'x'c'v
  Date: 2024/3/2
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

<!--
<head>
  <title>My first JSP web</title>
  <style>
    h1 {
      text-align: center;
      color: red;
    }
    p {
      text-align: center;
    }
    a {
      text-decoration: none;
    }
    a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

-->

<h2>Welcome to My Oline Shop Home Page.</h2><br>
<form method="get" target="_blank" action="${pageContext.request.contextPath}/Search">
  <input type="text" name="txt" size="30"/>
  <select name="search">
    <option value="baidu">Baidu</option>
    <option value="bing">Bing</option>
    <option value="google">Google</option>
  </select>
  <input type="submit" value="Search"/>
</form>

<h1>Hello World! JSP</h1>
<%//<p>I will do my best to study JSP</p>%>
<p>
  <a href="https://www.ecjtu.edu.cn">go to ecjtu</a>
</p>
<p>
  <a href="Myjsp.jsp">Myjsp.jsp-week1</a>
</p>
<p>
  <a href="hello">HelloWorldServlet-week2</a>
</p>
<p>
  <a href="register.jsp">Register.jsp-week2</a>
</p>
<p>
  <a href="life">LifeCycleServlet-week3</a>
</p>
<p>
  <a href="register">RegisterServlet-week3</a>
</p>
<p>
  <a href="config">ConfigDemoServlet-week4</a>
</p>
<p>
  <a href="jdbc">JDBCDemoServlet-week4</a>
</p >
<p>
  <a href="login.jsp">login.jsp-week5</a>
</p>
<p>
  <a href="login">LoginServlet-week5</a>
</p>


</body>

<%@include file="footer.jsp"%>