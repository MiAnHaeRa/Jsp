<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../public/header.jsp"/>

<p>${bvo }</p>
<h3>상세화면</h3>
<table class="table" border="1" style="width:800px">
	<tr>
		<th class="col-sm-2">글번호</th><td class="col-sm-4"><c:out value="${bvo.boardNo }"/></td>
		<th class="col-sm-2">조회수</th><td class="col-sm-4"><c:out value="${bvo.clickCnt }"/></td>
	</tr>
	<tr>
		<th>제목</th><td colspan="3" class="col-sm-3"><c:out value="${bvo.title }"/></td>
	</tr>
	<tr>
		<th>작성자</th><td class="col-sm-2"><c:out value="${bvo.writer }"/></td>
		<th>등록일시</th><td class="col-sm-2"><fmt:formatDate value="${bvo.creationDate }" pattern="yyyy년 MM월 dd일 HH시mm분ss초"/></td>
	</tr>
	<tr>
		<th>내용</th><td colspan="3" class="col-sm-3">${bvo.getContent() }</td>
	</tr>
	<tr>
		<td><button type="button" class="btn btn-secondary" onclick="getList()">목록가기</button></td>
		<c:choose>
			<c:when test="${!empty logId && logId == bvo.writer }">
				<td><button type="button" class="btn btn-success" onclick="modifyList()">수정하기</button></td>
				<td><button type="button" class="btn btn-danger" onclick="removeBoard()">바로삭제</button></td>
				<td><button type="button" class="btn btn-warning" onclick="removeBoardForm()">삭제화면</button></td>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</tr>
</table>

<p><c:out value="여기에 페이지 적음(${param.page })"/></p> 
<p><c:out value="여기에 페이지 적음(${paging.page })"/></p>
<script type="text/javascript">
	function getList() {
		location.href='boardList.do?page=${param.page}';
	}
	
	function modifyList() {
		location.href='modifyBoardForm.do?bno=${param.boardNo}&page=${param.page}';
	}
	
	function removeBoardForm() {
		location.href='removeBoardForm.do?bno=${param.boardNo}&page=${param.page}';
	}

	function removeBoard() {
		if(confirm("정말로 해당 게시물을 삭제하시겠습니까?")) {
			alert("삭제되었습니다.")
			location.href='removeBoard.do?bno=${param.boardNo}&page=${param.page}';
		} else {
			alert("삭제를 취소합니다.")
		}
	}
	
</script>
<jsp:include page="../public/footer.jsp"/>