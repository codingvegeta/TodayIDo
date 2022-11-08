<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오후 1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="http://search.daum.net/search" var="searchUrl">
  <c:param name="w" value="blog"/>
  <c:param name="q" value="공원"/>
</c:url>

<ul>
  <li>${searchUrl}</li>
  <li><c:url value="/chap12/use_if_tag.jsp"/> </li>
  <li><c:url value="use_if_tag.jsp"/> </li>
</ul>

</body>
</html>
