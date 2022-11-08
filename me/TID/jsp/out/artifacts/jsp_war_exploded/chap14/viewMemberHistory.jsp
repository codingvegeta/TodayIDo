<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-10
  Time: 오전 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.io.Reader" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.*" %>

<%
    String memberID = request.getParameter("memberID");
%>
<html>
<head>
    <title>회원정보</title>
</head>
<body>

<%
    Class.forName("com.mysql.jdbc.Driver");

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        String jdbcDriver = "jdbc:mysql://localhost:3306/chap14?" +
                "useUnicode=true&characterEncoding=utf8";
        String dbUser = "jspexam";
        String dbPass = "jsppw";
        String query = "select * from MEMBER_HISTORY "+
                "where MEMBERID = '"+memberID+"'";
        conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
        stmt = conn.createStatement();

        rs = stmt.executeQuery(query);
        if (rs.next()) {
%>
<table border="1">
    <tr>
        <td>아이디</td>
        <td><%=memberID%>
        </td>
    </tr>
    <tr>
        <td>히스토리</td>
        <td>
            <%
                String history = null;
                Reader reader = null;
                try {
                    reader = rs.getCharacterStream("HISTORY");

                    if (reader != null) {
                        StringBuilder buff = new StringBuilder();
                        char[] ch = new char[512];
                        int len = -1;

                        while ((len = reader.read(ch)) != -1) {
                            buff.append(ch, 0, len);
                        }

                        history = buff.toString();
                    }
                } catch (IOException exception) {
                    out.print("익셉션 발생:" + exception.getMessage());
                } finally {
                    if (reader != null) try {
                        reader.close();
                    } catch (IOException ex) {
                    }
                }
            %>
            <%= history %>
        </td>
    </tr>
</table>
<%
} else {
%>
<%= memberID %> 회원의 히스토리가 없습니다.
<%
    }
} catch (SQLException ex) {
%>
에러 발생 : <%= ex.getMessage()%>
<%
    } finally {
        if (rs != null) try {
            rs.close();
        } catch (SQLException ex) {
        }
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

</body>
</html>
