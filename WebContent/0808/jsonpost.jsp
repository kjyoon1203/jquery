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
		// post방식
		request.setCharacterEncoding("UTF-8");	// get방식은 server.xml에서 URIEncoding 처리를 해주었으므로 따로 jsp에서 처리안해도 됨.
		
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
	%>
	
	<%=name %>님! 환영합니다.<br>
	<%=tel %>번호로 연락드리겠습니다.<br>
	<h3>즐거운 하루 되세요~</h3>	
</body>
</html>