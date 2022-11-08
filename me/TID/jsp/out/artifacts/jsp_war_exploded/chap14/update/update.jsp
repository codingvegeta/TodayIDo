<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오후 7:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.SQLException" %>

<%
    request.setCharacterEncoding("utf-8");

    String memberID = request.getParameter("memberID");
    String name = request.getParameter("name");

    int updateCount = 0;

    Class.forName("com.mysql.jdbc.Driver");

    Connection conn = null;
    Statement stmt = null;

    try {
        String jdbcDrive = "jdbc:mysql://localhost:3306/chap14?" +
                "useUnicode=trye&characterEncoding=utf8";
        String dbUser = "jspexam";
        String dbPass = "jsppw";

        String query = "update MEMBER set NAME = '"+ name +"'"+ "WHERE MEMBERID = '" + memberID +"'";

        conn = DriverManager.getConnection(jdbcDrive, dbUser, dbPass);
        stmt = conn.createStatement();
        updateCount = stmt.executeUpdate(query);

    } finally {
        if (stmt != null) try {
            stmt.close();
        } catch (SQLException ex) {
        }
        if (conn != null) try {
            conn.close();
        } catch (SQLException ex) {
        }
    }
%>
<html>
<head>
    <title>이름변경</title>
</head>
<body>
<% if (updateCount > 0) { %>
<%= memberID %>의 이름은 <%= name %> (으)로 변경
<% } else { %>
<%= memberID%> 아이디가 존재하지 않음
<%}%>
</body>
</html>
