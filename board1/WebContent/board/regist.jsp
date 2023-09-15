<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="vo" class="board.BoardVo"/>
<jsp:useBean id="dao" class="board.BoardDao"/>
<jsp:setProperty name="vo" property="*"/>
<% 
request.setCharacterEncoding("UTF-8");
%>    
<%
	dao.insert(vo);
%>
<c:redirect url="${page.Context.request.contextPath}/board/list.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>
</head>
<body>

</body>
</html>