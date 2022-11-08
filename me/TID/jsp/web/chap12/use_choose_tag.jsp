<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오전 3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose 태그</title>
</head>
<body>
<ul>
    <c:choose>
    <c:when test="${param.name == 'bk'}">
    <il>당신의 이름은 ${param.name} 입니다
        </c:when>
        <c:when test="${param.age > 20}">
        <li> 당신은 20세 이상입니다.
            </c:when>
            <c:otherwise>
        <li>당신은 'bk'가 아니고 20세 이상이 아닙니다.
            </c:otherwise>
            </c:choose>
</ul>
</body>
</html>
