<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보확인</title>
</head>
<body>

	<!-- 현재 회원의 ID / PASS / 이름 내용을 현재 페이지로 출력 -->
<table border="1">
		<tr>
			<th bgcolor="orange" width="100">ID</th>
			<th bgcolor="orange" width="200">비밀번호</th>
			<th bgcolor="orange" width="150">이름</th>
			
		</tr>

		<tr>
			<td>${sessionScope.userId }</td>
			<td>${sessionScope.userName }</td>
			<td>${sessionScope.userPass }</td>
		
		
		</tr>
	
	</table>
	



</body>
</html>