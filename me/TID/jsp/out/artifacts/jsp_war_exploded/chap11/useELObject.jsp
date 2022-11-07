<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-08
  Time: 오전 3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("name","최범균");
%>
<html>
<head>
    <title>EL object</title>
</head>
<body>
<%=request.getParameter("name")%>
<%=request.getParameter("최범균")%>
<%=request.getAttribute("name")%>
<%=request.getAttribute("최범균")%>
요청 URI : ${pageContext.request.requestURI}<br>
request의 name 속성 : ${requestScope.name}<br>
code 파라미터 : ${param.code}

</body>
</html>
