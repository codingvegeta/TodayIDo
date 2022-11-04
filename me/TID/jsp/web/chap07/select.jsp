<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-05
  Time: 오전 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>옵션 선택 화면</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/chap07/view.jsp">

  보고 싶은 페이지 선택 :
  <select name = "code">
    <option value="A">A 페이지</option>
    <option value="B">B 페이지</option>
    <option value="C">C 페이지</option>
  </select>

  <input type="submit" value="이동">
</form>


</body>
</html>
