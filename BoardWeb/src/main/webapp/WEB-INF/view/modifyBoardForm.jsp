<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<jsp:include page="../public/header.jsp"/>

<form action="modifyBoard.do" method="post" style="width:800px;">
<input type="hidden" name="page" value="${param.page }">
<input type="hidden" name="boardNo" value="${bvo.boardNo }">
<input type="hidden" name="clickCnt" value="${bvo.clickCnt }" >

	<table class="table" border="1">
		<tr>
			<th class="col-sm-1">글번호</th>
			<td class="col-sm-1">${bvo.boardNo }</td>
			<th class="col-sm-1">조회수</th>
			<td class="col-sm-1">${bvo.clickCnt }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input name="title" type="text"
				value="${bvo.title }" style="width:100%"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><input name="writer" type="text"
				value="${bvo.writer }" style="width:100%"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea name="content" rows="15" style="width:100%">${bvo.content }</textarea></td>
		</tr>

		<tr>
			<td colspan="2"><button type="button" class="btn btn-primary"
					onclick="location.href='boardList.do?page=${param.page }'">목록으로 돌아가기</button></td>
			<td colspan="2"><button type="submit" class="btn btn-primary">수정하기</button></td>
		</tr>
	</table>
</form>

<jsp:include page="../public/footer.jsp"/>