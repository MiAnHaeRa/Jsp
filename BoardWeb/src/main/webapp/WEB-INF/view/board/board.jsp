<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style>
table {
	margin: 0 auto;
}

div.reply, div.header {
	width: 1000px;
}

div.reply div {
	margin: auto;
}

div.reply ul {
	list-style-type: none;
	margin-top: 3px;
}

div.reply li {
	padding-top: 1px;
	padding-bottom: 1px;
}

div.reply span {
	display: inline-block;
	text-align: center;
}

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

<h3>상세화면</h3>
<table class="table" border="1" style="width: 1000px">
	<tr>
		<th class="col-sm-2">글번호</th>
		<td class="col-sm-4"><c:out value="${bvo.boardNo }" /></td>
		<th class="col-sm-2">조회수</th>
		<td class="col-sm-4"><c:out value="${bvo.clickCnt }" /></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3" class="col-sm-3"><c:out value="${bvo.title }" /></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td class="col-sm-2"><c:out value="${bvo.writer }" /></td>
		<th>등록일시</th>
		<td class="col-sm-2"><fmt:formatDate value="${bvo.creationDate }"
				pattern="yyyy년 MM월 dd일 HH시mm분ss초" /></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3" class="col-sm-3">${bvo.getContent() }</td>
	</tr>
	<tr>
		<td colspan="4">
			<button type="button" class="btn btn-secondary"
				onclick="getList()">목록가기</button>
			<c:choose>
				<c:when test="${!empty logId && logId == bvo.writer }">
					<button type="button" class="btn btn-success"
							onclick="modifyList()">수정하기</button>
					<button type="button" class="btn btn-danger"
							onclick="removeBoard()">바로삭제</button>
					<button type="button" class="btn btn-warning"
							onclick="removeBoardForm()">삭제화면</button>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>

<!-- 댓글관련 시작 -->
<div class="container reply">
	<div class="header">
		<input type="text" class="col-sm-8" id="reply">
		<button class="col-sm-3 btn btn-primary" id="addReply">댓글 등록</button>
	</div>
	<div class="content">
		<ul>
			<li><span class="col-sm-1">글번호</span> <span class="col-sm-4">글내용</span>
				<span class="col-sm-2">작성자</span> <span class="col-sm-3">작성일자</span>
				<span class="col-sm-1">삭제버튼</span></li>
			<li><hr /></li>
			<li style="display: none;"><span class="col-sm-1">3</span> <span
				class="col-sm-4">asdasdasdasd</span> <span class="col-sm-1">user01</span>
				<span class="col-sm-3">2024-06-20 13:22:33</span></li>
		</ul>
	</div>
</div>

<div class="footer">
	<div class="center">
		<div class="pagination">
			<a href="#">1</a> <a href="#" class="active">2</a> <a href="#">3</a>
			<a href="#">4</a>
		</div>
	</div>
</div>
<!-- 댓글관련 끝, -->

<script type="text/javascript">
	const bno = "${bvo.boardNo }";
	const replyer = "${logId}";
	function getList() {
		location.href = 'boardList.do?page=${param.page}&searchCondition=${searchCondition }&keyword=${keyword }';
	}

	function modifyList() {
		location.href = 'modifyBoardForm.do?bno=${param.boardNo}&page=${param.page}&searchCondition=${searchCondition }&keyword=${keyword }';
	}

	function removeBoardForm() {
		location.href = 'removeBoardForm.do?bno=${param.boardNo}&page=${param.page}';
	}

	function removeBoard() {
		if (confirm("정말로 해당 게시물을 삭제하시겠습니까?")) {
			alert("삭제되었습니다.")
			location.href = 'removeBoard.do?bno=${param.boardNo}&page=${param.page}';
		} else {
			alert("삭제를 취소합니다.")
		}
	}
</script>
<script src="js/replyService.js"></script>
<script src="js/reply.js"></script>
