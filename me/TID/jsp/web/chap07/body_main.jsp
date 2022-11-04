<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-04
  Time: 오전 2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title>INFO</title>
</head>
<body>

include 전 name 파라미터 값 : <%=request.getParameter("name")%>

<hr>

<jsp:include page="body_sub.jsp" flush="false">
    <jsp:param name="name" value="최범균"/>
</jsp:include>

<hr/>

include 후 name 파라미터 값 : <%= request.getParameter("name")%>

</body>
</html>
