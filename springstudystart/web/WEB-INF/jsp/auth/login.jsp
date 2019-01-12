<%--
  Created by IntelliJ IDEA.
  User: saint
  Date: 2018-12-17
  Time: 오후 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>login</title>
    <style>
        .msg{
            font-weight: bold;
            color: red;
        }
    </style>
</head>
<body>
    <h1>로그인</h1>
    <form action="/auth/login.do" method="post">
        <p>
            ID : <input name="username" placeholder="아이디를 입력하세요.">
        </p>
        <p>
            PW : <input name="password" placeholder="패스워드를 입력하세요.">
        </p>
        <p>
            <button type="submit">로그인</button>
        </p>
    </form>

    <c:if test="${!empty msg}">
            <div class="msg">${msg}</div>
    </c:if>
</body>
</html>
