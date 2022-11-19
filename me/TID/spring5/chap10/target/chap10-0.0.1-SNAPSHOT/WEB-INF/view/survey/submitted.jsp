<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-20
  Time: 오전 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>응답 내용</title>
</head>
<body>
<p>응답 내용</p>
<ul>
  <c:forEach var="response"
  items="${ansData.responses}" varStatus="satatus">
    <li>${status.index + 1}번 문항: ${response}</li>
  </c:forEach>
</ul>
<p>응답자 위치: ${ansData.res.location}</p>
<p>응답자 나이: ${ansData.res.age}</p>
</body>
</html>
