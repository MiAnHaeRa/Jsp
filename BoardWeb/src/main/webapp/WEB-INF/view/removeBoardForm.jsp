<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>
<%
BoardVO bvo = (BoardVO) request.getAttribute("bvo");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초");
String yyyymmdd = sdf.format(bvo.getCreationDate());
String nowpage = request.getParameter("page");
%>
<table class="table" border="1" style="width:800px">
	<tr>
		<th class="col-sm-2">글번호</th><td class="col-sm-4"><%=bvo.getBoardNo() %></td>
		<th class="col-sm-2">조회수</th><td class="col-sm-4"><%=bvo.getClickCnt() %></td>
	</tr>
	<tr>
		<th>제목</th><td colspan="3" class="col-sm-3"><%=bvo.getTitle()%></td>
	</tr>
	<tr>
		<th>작성자</th><td colspan="3" class="col-sm-3"><%=bvo.getWriter()%></td>
	</tr>
	<tr>
		<th>내용</th><td colspan="3" class="col-sm-3"><%=bvo.getContent()%></td>
	</tr>
	<tr>
		<th>등록일시</th><td colspan="3" class="col-sm-3"><%=yyyymmdd %></td>
	</tr>
	<tr>
		<td colspan="2" ><button type="button" class="btn btn-secondary" onclick="location.href='boardList.do?page=<%=nowpage %>'">목록으로 돌아가기</button></td>
		<td colspan="2" ><button type="button" class="btn btn-danger" onclick="removeBoard()">바로삭제</button></td>
	</tr>
</table>
<script type="text/javascript">
	function removeBoard() {
		if(confirm("정말로 해당 게시물을 삭제하시겠습니까?")) {
			alert("삭제되었습니다.")
			location.href='removeBoard.do?bno=<%=bvo.getBoardNo()%>&page=<%=nowpage %>'
		} else {
			alert("삭제를 취소합니다.")
		}
	}
	
</script>
<%@include file="../public/footer.jsp"%>