<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>year=<%=request.getParameter("year") %></h1>
<P> ${myDate.year}년 ${myDate.month}월 ${myDate.day}일은 ${yoil}입니다.</P>

</body>
</html>
