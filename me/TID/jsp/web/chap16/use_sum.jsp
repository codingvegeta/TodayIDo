<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-14
  Time: 오전 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>sum 사용</title>
</head>
<body>

<tf:sum begin="1" end="10">
  1-10까지 합 : ${sum}
</tf:sum>
</body>
</html>
