<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-15
  Time: 오전 3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/chap19/login.jsp">
    아이디<input type="text" name="memberId">
    암호<input type="password" name="password">
    <input type="submit" value="로그인">
</form>
</body>
</html>
