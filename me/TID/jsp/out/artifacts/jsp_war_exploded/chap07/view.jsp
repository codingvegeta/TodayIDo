<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-05
  Time: 오전 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String code = request.getParameter("code");
  String viewPageURI = null;

  if (code.equals("A")) {
    viewPageURI = "/chap07/viewModule/a.jsp";
  } else if (code.equals("B")) {
    viewPageURI = "/chap07/viewModule/b.jsp";
  }else if (code.equals("C")) {
    viewPageURI = "/chap07/viewModule/c.jsp";
  }
%>
<jsp:forward page="<%=viewPageURI%>"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
