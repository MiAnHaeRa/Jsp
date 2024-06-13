<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	
<jsp:include page="../public/header.jsp"/>
<table class="table" border="1" style="width:800px">
	<tr>
		<th class="col-sm-2">글번호</th><td class="col-sm-4">${bvo.boardNo }</td>
		<th class="col-sm-2">조회수</th><td class="col-sm-4">${bvo.clickCnt }</td>
	</tr>
	<tr>
		<th>제목</th><td colspan="3" class="col-sm-3">${bvo.title }</td>
	</tr>
	<tr>
		<th>작성자</th><td colspan="3" class="col-sm-3">${bvo.writer }</td>
	</tr>
	<tr>
		<th>내용</th><td colspan="3" class="col-sm-3">${bvo.content }</td>
	</tr>
	<tr>
		<th>등록일시</th><td colspan="3" class="col-sm-3"><fmt:formatDate value="${bvo.creationDate }" pattern="yyyy년 MM월 dd일 HH시mm분ss초"/> </td>
	</tr>
	<tr>
		<td colspan="2" ><button type="button" class="btn btn-secondary" onclick="location.href='boardList.do?page=${param.page }'">목록으로 돌아가기</button></td>
		<td colspan="2" ><button type="button" class="btn btn-danger" onclick="removeBoard()">바로삭제</button></td>
	</tr>
</table>
<script type="text/javascript">
	function removeBoard() {
		if(confirm("정말로 해당 게시물을 삭제하시겠습니까?")) {
			alert("삭제되었습니다.")
			location.href='removeBoard.do?bno=${bvo.boardNo }&page=${param.page }'
		} else {
			alert("삭제를 취소합니다.")
		}
	}
	
</script>

<jsp:include page="../public/footer.jsp"/>