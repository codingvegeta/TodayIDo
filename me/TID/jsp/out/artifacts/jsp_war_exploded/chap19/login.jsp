<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-15
  Time: 오전 3:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String memberId = request.getParameter("memberId");
  session.setAttribute("MEMBER", memberId);
%>
<html>
<head>
    <title>로그인</title>
</head>
<body>
로그인 처리
</body>
</html>
