<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-15
  Time: 오전 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NullParameterFilter테스트</title>
</head>
<body>
id 파라미터 : <%= request.getParameter("id")%><br>
name 파라미터 : <%= request.getParameter("name")%><br>
member 파라미터 : <%= request.getParameter("member")%><br>
</body>
</html>
