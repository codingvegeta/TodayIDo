<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-06
  Time: 오후 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>세션객체 확인</title>
</head>
<body>
<%
    String name = (String) session.getAttribute("name");
%>
회원명: <%= name %>

</body>
</html>
