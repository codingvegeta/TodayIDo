<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-12
  Time: 오전 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="guestbook.model.Message" %>
<%@ page import="guestbook.service.WriteMessageService" %>
<%
  request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="message" class="guestbook.model.Message">
  <jsp:setProperty name="message" property="*"/>
</jsp:useBean>
<%
  WriteMessageService writeService = WriteMessageService.getInstance();
  writeService.write(message);
%>
<html>
<head>
    <title>방명록 메시지 남김</title>
</head>
<body>
방명록에 메시지를 남겼습니다.
<br/>
<a href="list.jsp">[목록 보기]</a>
</body>
</html>
