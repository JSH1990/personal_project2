<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="vo" class="board.BoardVo" />
<jsp:useBean id="dao" class="board.BoardDao" />
<jsp:setProperty name="vo" property="*"/>
<%
	dao.update(vo);
	pageContext.setAttribute("vo", vo);
%>

<c:redirect url="${page.Context.request.contextPath }/board/boardDetail.jsp?num=${vo.num }"></c:redirect>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>