<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-14
  Time: 오전 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>out</title>
</head>
<body>
<tf:out>
  <jsp:body><u>현재 시간</u>은 <b>${dateEL}</b> 입니다.</jsp:body>
</tf:out>

<tf:out>
  <%= new Date() %><u>현재 시간</u>은 <b>${dateEL}</b> 입니다.
</tf:out>

</body>
</html>
