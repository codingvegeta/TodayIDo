<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오후 5:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>회원 목록</title>
</head>
<body>
MEMBER 테이블의 내용
<table width="100%" border="1">
    <tr>
        <td>이름</td>
        <td>아이디</td>
        <td>이메일</td>
    </tr>
    <%
        //1.JDBC 드라이버 로딩
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String jdbcDriver = "jdbc:mysql://localhost:3306/chap14?" +
                    "useUnicode=true&characterEncoding=utf-8";
            String dbUser = "jspexam";
            String dbpass = "jsppw";

            String query = "select * from MEMBER order by MEMBERID";

            //2. 데이터베이스 커넥션 생성

            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbpass);

            //3. Statement 생성
            stmt = conn.createStatement();

            //4. 쿼리 실행
            rs = stmt.executeQuery(query);

            //5. 쿼리 실행 결과 출력
            while (rs.next()) {
    %>
    <tr>
        <td><%=rs.getString("NAME")%>
        </td>
        <td><%=rs.getString("MEMBERID")%>
        </td>
        <td><%=rs.getString("EMAIL")%>
        </td>
    </tr>
    <%
            }
        } catch (SQLException ex) {
            out.println(ex.getMessage());
            ex.printStackTrace();
        }finally {
            //6. 사용한 Statement 종료
                if (rs != null) try {rs.close();} catch (SQLException ex) {}
                if (stmt != null) try {stmt.close();} catch (SQLException ex){}

                //7. 커넥션 종료
                if(conn != null)try{conn.close();}catch (SQLException ex){}
            }
    %>
</table>

</body>
</html>
