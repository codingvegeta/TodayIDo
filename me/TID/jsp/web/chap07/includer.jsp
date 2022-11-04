<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-04
  Time: 오전 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include 디렉시브</title>
</head>
<body>

<%
  int number = 10;
%>

<%@ include file="/chap07/includee.jspf"%>
공통변수 DATAFOLDER = "<%=dataFolder%>"

</body>
</html>
