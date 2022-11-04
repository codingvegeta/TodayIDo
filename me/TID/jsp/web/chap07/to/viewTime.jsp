<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-05
  Time: 오전 3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Calendar" %>
<html>
<head>
    <title>현재 시간</title>
</head>
<body>

<%
  Calendar cal = (Calendar) request.getAttribute("time");
%>
현재 시간은 <%= cal.get(Calendar.HOUR)%> 시
 <%= cal.get(Calendar.MINUTE)%> 분
 <%= cal.get(Calendar.SECOND)%> 초 입니다.
</body>
</html>
