<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.*, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	BoardDao dao = new BoardDao();
	List<BoardVo> ls = dao.selectAll();
	pageContext.setAttribute("ls", ls);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
<h2>게시글 목록</h2>
<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>내용</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
<c:forEach var="board" items="${ls}">
<tr>
	<td>${board.num}</td>
	<td>${board.title}</td>
	<td>${board.writer}</td>
	<td>${board.content}</td>
	<td>${board.regDate}</td>
	<td>${board.cnt}</td>
</tr>	
</c:forEach>
</table>
<a href="<c:url value="/board/registForm.jsp"/>"><button>글등록</button></a>
</body>
</html>