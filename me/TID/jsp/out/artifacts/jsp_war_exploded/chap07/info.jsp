<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-04
  Time: 오전 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INFO</title>
</head>
<body>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td>제품번호</td><td>XXXX</td>
    </tr>
    <tr>
        <td>가격</td><td>10,000원</td>
    </tr>
</table>

<jsp:include page="infosub.jsp" flush="false">
    <jsp:param name="type" value="a"/>
</jsp:include>

</body>
</html>
