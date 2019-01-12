<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
    .nav{

    }
</style>
<div class="nav">
    <ul>
        <c:choose>
            <c:when test="${user != null}">
                <li>
                    <a href="${pageContext.request.contextPath}/auth/logout.do">로그아웃</a>
                </li>
            </c:when>
            <c:otherwise>
                <li>
                    <a href="${pageContext.request.contextPath}/auth/login.do">로그인</a>
                </li>
            </c:otherwise>
        </c:choose>

    </ul>
</div>