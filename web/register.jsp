<%--
  Created by IntelliJ IDEA.
  User: 1234e's'z'x'c'v
  Date: 2024/3/16
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <title>JSPWebWeek2Homework2</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            background: #f0f0f0;
        }

        #header-container {
            flex: 0 0 auto; /* header不随内容伸缩，始终保持固定大小 */
        }

        #footer-container {
            flex: 0 0 auto; /* footer不随内容伸缩，始终保持固定大小 */
        }

        #container1 {
            width: 300px;
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: auto;
        }

        .r-input {
            margin-bottom: 10px;
        }

        .r-gender {
            margin-bottom: 10px;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        #submit {
            width: 100%;
            height: 40px;
            border: none;
            border-radius: 5px;
            background: #007bff;
            color: white;
            cursor: pointer;
        }

        #submit:hover {
            background: #0056b3;
        }
    </style>

</head>
<body>

<div id="header-container">
    <%@ include file="header.jsp" %>
</div>

<div id="container1">
    <form id="register" method="post" action="${pageContext.request.contextPath}/register">

        <div class="r-input">
            <label >Username</label><br>
            <input Type="text" name="Username"><br>
        </div>

        <div class="r-input">
            <label >Password</label><br>
            <input Type="password" name="Password"><br>
        </div>

        <div class="r-input">
            <label >Email</label><br>
            <input Type="text" name="Email"><br>
        </div>

        <div class="r-gender">
            <label >Gender</label><br>
            <input  type="radio" name="Gender" value="male"/><label>male</label>
            <input  type="radio" name="Gender" value="female"/><label>female</label>
        </div>

        <div class="r-input">
            <label >Birthdate</label><br>
            <input Type="text" name="Birthdate"
                   pattern="\d{4}-\d{2}-\d{2}"
                   title="请输入格式为YYYY-MM-DD的生日，例如：1999-01-01"><br>
        </div>

        <div class="r-input">
            <input Type="submit" id="submit" value="Click Here Submit"><br>
        </div>
    </form>
</div>

<div id="footer-container">
    <%@ include file="footer.jsp" %>
</div>


</body>

