<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-06
  Time: 오전 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.net.URLEncoder" %>
<%
    Cookie cookie = new Cookie("name", URLEncoder.encode("최범균","utf-8"));
    response.addCookie(cookie);
%>
<html>
<head>
    <title>쿠키생성</title>
</head>
<body>

<%= cookie.getName()%> 쿠키의 값="<%= cookie.getValue()%>"

</body>
</html>
