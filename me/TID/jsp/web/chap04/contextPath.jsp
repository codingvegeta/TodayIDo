<%@ page contentType="text/html; charset=utf-8"%>
<%--웹 어플리케이션 콘텍스트 경로를 구할 수있다 .지금 내 파일은 /me로 나온다.--%>
<html>
<head><title> 웹 어플리케이션 경로 구하기</title></head>
<body>

웹 어플리케이션 컨텍스트 경로: "<%=request.getContextPath()%>"

</body>
</html>