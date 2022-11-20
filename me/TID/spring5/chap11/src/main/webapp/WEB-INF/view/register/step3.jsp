<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-19
  Time: 오전 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="member.register"/></title>
</head>
<body>
<p>
    <spring:message code="register.done"
    arguments="${registerRequest.name}"/>
</p>
<p><a href="<c:url value='/main'/> ">[첫 화면 이동]</a> </p>
[<spring:message code="go.mail"/>]
</body>
</html>
