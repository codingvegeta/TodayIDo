<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-06
  Time: 오전 3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.Cookies" %>
<%
  response.addCookie(Cookies.createCookie("AUTH", "", "/", 0));
%>
<html>
<head>
    <title>로그아웃</title>
</head>
<body>

로그아웃 하였습니다.

</body>
</html>
