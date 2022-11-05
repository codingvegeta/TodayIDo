<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-06
  Time: 오전 3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.Cookies" %>
<%
    response.addCookie(Cookies.createCookie("name","최범균"));
    response.addCookie(Cookies.createCookie("id", "madvirus", "/chap09", -1));
%>
<html>
<head>
    <title>Cookie 사용 예</title>
</head>
<body>

Cookies를 사용하여 쿠키 생성

</body>
</html>
