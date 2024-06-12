<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>
<%
BoardVO bvo = (BoardVO) request.getAttribute("bvo");
%>
<form action="modifyBoard.do" method="post" style="width:800px;">
	<table class="table" border="1">
		<tr>
			<th>글번호</th>
			<td><input type="text" name="boardNo" value="<%=bvo.getBoardNo()%>" readonly style="width:100%"></td>
			<th>조회수</th>
			<td><input type="text" name="clickCnt" value="<%=bvo.getClickCnt()%>" readonly style="width:100%"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input name="title" type="text"
				value="<%=bvo.getTitle()%>" style="width:100%"></td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td colspan="3"><input name="writer" type="text"
				value="<%=bvo.getWriter()%>" style="width:100%"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea name="content" rows="15" style="width:100%"><%=bvo.getContent()%></textarea></td>
		</tr>

		<tr>
			<td><button type="button" class="btn btn-primary"
					onclick="location.href='boardList.do'">목록으로 돌아가기</button></td>
			<td><button type="submit" class="btn btn-primary">수정하기</button></td>
		</tr>
	</table>
</form>
<%@include file="../public/footer.jsp"%>