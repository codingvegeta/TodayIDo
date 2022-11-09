<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오전 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="jdbc.connection.ConnectionProvider" %>
<html>
<head>
    <title>연결 테스트</title>
</head>
<body>
<%
    try (Connection conn = ConnectionProvider.getConnection()) {
        out.println("커넥션 연결 성공함");
    } catch (SQLException ex) {
        out.println("커넥션 연결 실패함:" + ex.getMessage());
        application.log("커넥션 연결 실패", ex);
    }
%>
</body>
</html>
