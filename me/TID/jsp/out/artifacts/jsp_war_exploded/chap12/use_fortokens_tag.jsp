<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오후 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>forTokens 태그</title>
</head>
<body>

콤마와 점을 구분자로 사용 :<br>
<c:forTokens var="token" items="빨강색,주황색.노란색.초록색,파랑색,남색.보라색" delims=",.">
    ${token}
</c:forTokens>
</body>
</html>
