<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-05
  Time: 오전 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="memberInfo" class="chap08.member.MemberInfo"/>
<jsp:setProperty name="memberInfo" property="*"/>
<jsp:setProperty name="memberInfo" property="password"
                 value="<%= memberInfo.getId()%>"/>
<html>
<head>
    <title>가입</title>
</head>
<body>

<table width="400" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td>아이디</td>
    <td><jsp:getProperty name="memberInfo" property="id"/></td>
    <td>암호</td>
    <td><jsp:getProperty name="memberInfo" property="password"/></td>
  </tr>
  <tr>
    <td>이름</td>
    <td><jsp:getProperty name="memberInfo" property="name"/></td>
    <td>이메일</td>
    <td><jsp:getProperty name="memberInfo" property="email"/></td>
  </tr>
</table>

</body>
</html>
