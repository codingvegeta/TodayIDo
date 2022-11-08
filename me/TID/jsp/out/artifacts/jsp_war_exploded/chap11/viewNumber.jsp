<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오전 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="elfunc" uri="/chap11/el-functions.tld" %>
<%
  request.setAttribute("price",12345);
%>
<html>
<head>
    <title>EL 함수 호출</title>
</head>
<body>

오늘은 <b>${elfunc:formatNumber(price, "#,##0")}</b> 입니다.
</body>
</html>
