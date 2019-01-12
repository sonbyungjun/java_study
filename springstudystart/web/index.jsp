<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: saint
  Date: 2018-12-16
  Time: 오후 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
    <h1>홈 화면</h1>

    <c:choose>
      <c:when test="${user != null}">
        <h3>${user.name}님 안녕하세요.</h3>
      </c:when>
      <c:otherwise>
        <h3>손님 안녕하세요.</h3>
      </c:otherwise>
    </c:choose>

    <%@ include file="/WEB-INF/jsp/common/nav.jsp"%>


  </body>
</html>
