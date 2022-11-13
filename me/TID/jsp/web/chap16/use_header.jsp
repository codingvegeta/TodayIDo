<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-13
  Time: 오후 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>제목출력</title>
</head>
<body>
<tf:header title="텍스트 제목" level="2"/>

<tf:header title="${'EL 제목'}" level="3"/>

<tf:header title='<%="표현식 제목"%>'/>


</body>
</html>
