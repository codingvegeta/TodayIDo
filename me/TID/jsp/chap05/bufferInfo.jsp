<%@ page contentType="text/html; charset=utf-8" %>
<%@ page buffer="8kb" autoFlush="false" %>
<%--버퍼의 크기를 8kb로 오토플러시를 false 로 지정--%>
<html>
<head><title>버퍼 정보</title></head>
<body>

버퍼 크기 : <%= out.getBufferSize()%> <br>
남은 크기 : <%= out.getRemaining()%> <br>
auto flush : <%= out.isAutoFlush()%> <br>

</body>
</html>

<%-- 결과값 : 버퍼 크기 : 8192 남은 크기 : 8111 auto flush : false --%>