<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오전 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    if (id.equals(password)) {
        session.setAttribute("MEMBERID", id);
%>
<html>
<head>
    <title>로그인 성공</title>
</head>
<body>

로그인에 성공했습니다.

</body>
</html>
<%
} else { //로그인 실패시
%>
<script>
    alert("로그인에 실패하였습니다.")
    history.go(-1)
</script>
<%
    }
%>
