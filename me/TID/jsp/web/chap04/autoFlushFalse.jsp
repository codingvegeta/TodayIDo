<%@ page contentType="text/html; charset=utf-8"%>
<%@ page buffer="1kb" autoFlush="false" %>
<%--autoflush가 false로 되어있을경우 버퍼가 가득 찰 경우 JSP overflow를 발생시킨다.--%>
<html>
<head><title>autoFlush 속성값 false 예제</title></head>
<body>

<% for (int i = 0; i < 1000; i++) { %>
1234
<% } %>

</body>
</html>