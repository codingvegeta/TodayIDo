<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오후 2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>catch 태그</title>
</head>
<body>

<c:catch var="ex">
  name 파라미터의 값 = <%=request.getParameter("name")%><br>
  <% if(request.getParameter("name").equals("test")){ %>
  ${param.name} 은 test입니다.
  <%}%>
</c:catch>
<p>
  <c:if test="${ex != null}">
    익셉션이 발생하였습니다:<br>
    ${ex}
  </c:if>
</p>
</body>
</html>
