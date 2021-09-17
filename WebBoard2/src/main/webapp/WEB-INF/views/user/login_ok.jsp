<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그인 성공하였습니다.<hr>
	${sessionScope.userName } 님 안녕하세요^^<br>
	
	${sessionScope.sessionTime }<br>
	
	<a href='memberInfo.do'>마이페이지 </a>
	
</body>
</html>
