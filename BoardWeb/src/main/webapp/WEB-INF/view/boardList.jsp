<%@page import="co.yedam.common.PageDTO"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<h3>게시글 목록(boardList.jsp)</h3>
<c:if test="${!empty logId }">
<div id="Btns">
	<button id="addBtn" class="btn btn-primary" type="button" onclick="location.href='addForm.do'">게시물 작성</button>
</div>
</c:if>
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
	<c:forEach var="vo" items="${boardList }">
		<tr onclick="location.href='getBoard.do?boardNo=<c:out value="${vo.boardNo }"/>&page=<c:out value="${paging.page }"/>'">
			<td><c:out value="${vo.boardNo }"/></td>
			<td><c:out value="${vo.title }"/></td>
			<td><c:out value="${vo.writer }"/></td>
			<td><c:out value="${vo.clickCnt }"/></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div class="center">
	<div class="pagination">
		<c:if test="${paging.prev }">
			<a href="boardList.do?page=${paging.startPage - 1 }">&laquo;</a>
		</c:if>
		<c:forEach var="p" begin="${paging.startPage }" end="${paging.endPage }" step="1">
			<c:choose>
				<c:when test="${p == paging.page }">
					<a href="boardList.do?page=<c:out value="${p }"/>" class="active"><c:out value="${p }"/></a>
				</c:when>
				<c:otherwise>
					<a href="boardList.do?page=<c:out value="${p }"/>"><c:out value="${p }"/></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.next }">
			<a href="boardList.do?page=${paging.endPage + 1 }">&raquo;</a>
		</c:if>
	</div>
</div>

<%@include file="../public/footer.jsp"%>