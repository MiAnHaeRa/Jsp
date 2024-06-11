<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- "boardList에 담긴 값을 읽어서 반복처리 -->
<%@include file="../public/header.jsp"%>
<%
	//request는 jsp 내장객체
	List<BoardVO> list =(List<BoardVO>)request.getAttribute("boardList");
%>
<h3>게시글 목록</h3>
<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
		</tr>
		<%for(BoardVO vo : list) { %>
		<tr><a href="./getBoard.do?boardNo=<%=vo.getBoardNo() %>">
			<td><%=vo.getBoardNo() %></td>
			<td><%=vo.getTitle() %></td>
			<td><%=vo.getWriter() %></td>
			<td><%=vo.getClickCnt() %></td>
		</a></tr>
		<%} %>
	</tbody>
</table>

<%@include file="../public/footer.jsp"%>