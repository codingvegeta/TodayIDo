<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오후 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.IOException, java.io.FileReader" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>소스 보기</title>
</head>
<body>

<%
  FileReader reader = null;
  try {
    String path = request.getParameter("path");
    reader = new FileReader(request.getServletContext().getRealPath(path));
%>
  <Pre>
    소스 코드 = <%=path%>
    <c:out value="reader" escapeXml="true"/>
  </Pre>
<%
  }catch (IOException ex){
%>
에러: <%= ex.getMessage()%>
<%
  }finally {
    if (reader != null) {
      try {
        reader.close();
      }catch (IOException ex){}
    }
  }
%>
</body>
</html>
