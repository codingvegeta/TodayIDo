<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오전 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="chap11.FormatUtil" %>
<%
    request.setAttribute("price", 12345L);
%>
<html>
<head>
    <title>EL 함수 호출</title>
</head>
<body>

가격은 <b>${FormatUtil.number(price,'#,##0')}</b>원 입니다.
</body>
</html>
