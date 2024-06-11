<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>
<%
BoardVO bvo = (BoardVO) request.getAttribute("bvo");
%>
<table class="table" border="1">
	
	<tr>
		<th>제목</th>
		<td colspan="2"><%=bvo.getTitle()%></td>
		<td>글쓴이 : <%=bvo.getWriter()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><%=bvo.getContent()%></td>
	</tr>
	<tr>
		<td colspan="4"><button type="button" class="btn btn-primary" >목록으로 돌아가기</button></td>
	</tr>
</table>
<%@include file="../public/footer.jsp"%>