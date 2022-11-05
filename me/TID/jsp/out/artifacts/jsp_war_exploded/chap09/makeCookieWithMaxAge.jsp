<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-06
  Time: 오전 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Cookie cookie = new Cookie("oneh","1time");
  cookie.setMaxAge(60*60);//60초(1분) * 60 = 1시간
  response.addCookie(cookie);
%>
<html>
<head>
    <title>쿠키 유효시간 설정</title>
</head>
<body>

유효시간이 1시간인 oneh 쿠키 생성.

</body>
</html>
