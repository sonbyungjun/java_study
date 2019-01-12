<%--
  Created by IntelliJ IDEA.
  User: saint
  Date: 2018-12-10
  Time: 오후 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:out value="test" />
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a href="${pageContext.request.contextPath()}/hello.do">
      hello
    </a>
  </body>
</html>
