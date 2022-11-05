<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-06
  Time: 오전 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.Cookies" %>
<%
    Cookies cookies = new Cookies(request);
%>
<html>
<head>
    <title>로그인 여부 검사</title>
</head>
<body>

<%
    if (cookies.exists("AUTH")) {
%>
아이디 "<%= cookies.getValue("AUTH")%>"로 로그인 한 상태
<%
} else {
%>
로그인 하지 않은 상태
<%
    }
%>

</body>
</html>
