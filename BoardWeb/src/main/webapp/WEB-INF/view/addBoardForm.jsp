<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>

<h3>게시글 올리기</h3>
<form action="insertBoard.do" method="post" style="width:800px">
	<table class="table">
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" name="title" style="width:100%"></td>
			<th for="writer">글쓴이</th>
			<td><input type="text" name="writer" style="width:100%"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="5"><textarea name="content" rows="10" style="width:100%;"></textarea></td>	
		</tr>
		<tr>
			<td colspan="6"><button type="submit" class="btn btn-primary">게시글 작성</button></td>
		</tr>
	</table>
</form>
<%@include file="../public/footer.jsp"%>