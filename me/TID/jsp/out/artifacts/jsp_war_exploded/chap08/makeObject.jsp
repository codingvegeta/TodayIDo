<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-05
  Time: 오전 3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="member" scope="request" class="chap08.member.MemberInfo"/>
<%
    member.setId("madvirus");
    member.setName("최범균");
%>
<jsp:forward page="/chap08/useObject.jsp"/>