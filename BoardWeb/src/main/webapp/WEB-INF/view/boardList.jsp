<%@page import="co.yedam.common.PageDTO"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- "boardList에 담긴 값을 읽어서 반복처리 -->
<%@include file="../public/header.jsp"%>
<style>
.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
<%
//request는 jsp 내장객체
List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
PageDTO pageDTO = (PageDTO) request.getAttribute("paging");
String nowpage = (String)request.getAttribute("page");
%>
<h3>게시글 목록</h3>
<table class="table">
	<thead>
	<tbody>
		<tr>
			<button class="btn btn-primary" type="button"
				onclick="location.href='addForm.do'">게시물 작성</button>
		</tr>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<%
	for (BoardVO vo : list) {
	%>
	<tr onclick="location.href='getBoard.do?boardNo=<%=vo.getBoardNo()%>&page=<%=nowpage%>'">
		<td><%=vo.getBoardNo()%></td>
		<td><%=vo.getTitle()%></td>
		<td><%=vo.getWriter()%></td>
		<td><%=vo.getClickCnt()%></td>
	</tr>
	<%
	}
	%>
	</tbody>
</table>
<div class="center">
	<div class="pagination">
		<%if(pageDTO.isPrev()) { %>
		<a href="boardList.do?page=<%=pageDTO.getStartPage() - 1 %>">&laquo;</a> 
		<%} %>
		<%for(int p = pageDTO.getStartPage(); p <= pageDTO.getEndPage(); p++) { %>
			<%if(p == pageDTO.getPage()) {%>
				<a href="boardList.do?page=<%=p %>" class="active"><%=p %></a>
			<%} else { %>
				<a href="boardList.do?page=<%=p %>"><%=p %></a>
			<%}
		} %>
		<%if(pageDTO.isNext()) { %>
		<a href="boardList.do?page=<%=pageDTO.getEndPage() + 1 %>">&raquo;</a>
		<%} %>
	</div>
</div>

<%@include file="../public/footer.jsp"%>