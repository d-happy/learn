<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.invalidate(); // 세션 정보 무효화 -> 저장된 세션 정보 모두 삭제
	response.sendRedirect("request_form.jsp");
%>
</body>
</html>