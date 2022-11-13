<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-14
  Time: 오전 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>multiple 태그 사용</title>
</head>
<body>
<c:set var="num" value="${1}"/>
<tf:multiple count="10">
    ${num}<br/>
    <c:set var="num" value="${num+1}"/>
</tf:multiple>
</body>
</html>
