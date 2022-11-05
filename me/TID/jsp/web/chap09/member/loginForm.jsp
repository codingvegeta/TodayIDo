<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-06
  Time: 오전 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인폼</title>
</head>
<body>

<form action="<%= request.getContextPath()%>/chap09/member/login.jsp" method="post">
  아이디 <input type="text" name="id" size="10">
  암호 <input type="password" name="password" size="10">
  <input type="submit" value="로그인">
</form>

</body>
</html>
