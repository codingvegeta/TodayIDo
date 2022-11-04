<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-05
  Time: 오전 3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Calendar" %>
<%
  Calendar cal = Calendar.getInstance();
  request.setAttribute("time", cal);
%>
<jsp:forward page="/chap07/to/viewTime.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
