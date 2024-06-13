<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>
<%
BoardVO bvo = (BoardVO) request.getAttribute("bvo");
String nowpage = request.getParameter("page");
%>
<form action="modifyBoard.do" method="post" style="width:800px;">
<input type="hidden" name="page" value="<%=nowpage %>">
<input type="hidden" name="boardNo" value="<%=bvo.getBoardNo()%>">
<input type="hidden" name="clickCnt" value="<%=bvo.getClickCnt()%>" >

	<table class="table" border="1">
		<tr>
			<th class="col-sm-1">글번호</th>
			<td class="col-sm-1"><%=bvo.getBoardNo()%></td>
			<th class="col-sm-1">조회수</th>
			<td class="col-sm-1"><%=bvo.getClickCnt()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input name="title" type="text"
				value="<%=bvo.getTitle()%>" style="width:100%"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><input name="writer" type="text"
				value="<%=bvo.getWriter()%>" style="width:100%"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea name="content" rows="15" style="width:100%"><%=bvo.getContent()%></textarea></td>
		</tr>

		<tr>
			<td colspan="2"><button type="button" class="btn btn-primary"
					onclick="location.href='boardList.do?page=<%=nowpage %>'">목록으로 돌아가기</button></td>
			<td colspan="2"><button type="submit" class="btn btn-primary">수정하기</button></td>
		</tr>
	</table>
</form>
<%@include file="../public/footer.jsp"%>