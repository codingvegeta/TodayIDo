<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-14
  Time: 오전 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>removeHtml</title>
</head>
<body>

<c:set var="dateEL" value="<%= new Date()%>"/>
<tf:removeHtml trim="true">
  <font size="10"> 현재 <style>시간</style>은 ${dateEL} 입니다.</font>
</tf:removeHtml>
<br>
<tf:removeHtml length="15" trail="..." trim="true">
  <u>현재 시간</u>은 <b>${dateEL}</b> 입니다.
</tf:removeHtml>
<br>
<tf:removeHtml length="15">
  <jsp:body><u>현재 시간</u> 은 <b>${dateEL}</b> 입니다.</jsp:body>
</tf:removeHtml>


</body>
</html>
