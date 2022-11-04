<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import = "java.util.Calendar" %>
<%--Calendar 클래스를 임포트 했음--%>
<html>
<head><title>Calendar 클래스 사용 </title></head>
<body>
<%
    Calendar cal = Calendar.getInstance();
%>
<%--현재 날짜와 시간 정보를 가지고 있는 Calendar 클래스의 인스턴스를 생성--%>
오늘은
    <%= cal.get(Calendar.YEAR)%>년
    <%= cal.get(Calendar.MONTH) + 1%>월
    <%= cal.get(Calendar.DATE)%> 일
    입니다.
<%--출력--%>
</body>
<html>