<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-05
  Time: 오전 4:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="member" scope="request"
             class="chap08.member.MemberInfo"/>
<html>
<head>
    <title>인사말</title>
</head>
<body>

<%= member.getName()%> (<%=member.getId()%>)회원님
안녕하세요
</body>
</html>
