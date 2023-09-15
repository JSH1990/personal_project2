<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>
</head>
<body>
<form action="regist.jsp" method="post" acept-charset="UTF-8">
	<input type="text" name="title" placeholder="제목" required><br>
	<input type="text" name="writer" placeholder="작성자" required><br>
	<textarea rows="4" cols="8" name="content" placeholder="내용"></textarea><br>
	<input type="submit" value="등록">
</form>
</body>
</html>