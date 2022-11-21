<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-21
  Time: 오전 3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="login.title"/></title>
</head>
<body>
<form:form modelAttribute="loginCommand">
    <form:errors/>
    <p>
        <labe><spring:message code="email"/>:<br>
            <form:input path="email"/>
            <form:errors path="email"/>
        </labe>
    </p>
    <p>
        <labe><spring:message code="password"/>:<br>
            <form:input path="password"/>
            <form:errors path="password"/>
        </labe>
    </p>
    <p>
        <labe><spring:message code="rememberEmail"/>
        <form:checkbox path="rememberEmail"/>
        </labe>
    </p>
    <input type="submit" value="<spring:message code="login.btn"/> ">
</form:form>
</body>
</html>
