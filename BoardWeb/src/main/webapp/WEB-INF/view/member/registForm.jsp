<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>회원가입</h3>
<form action="regist.do" method="post" style="width:500px" enctype="multipart/form-data">
	<table class="table">
	<input type="hidden" value="${checked }" name="checked">
		<tr>
			<th>이름</th><td><input type="text" name="name" class="form-control" value="${name }" required></td>
		</tr>
		<tr>
			<th>아이디</th><td><input type="text" name="id" class="form-control" value="${id }" required></td>
		</tr>
		<%-- <tr>
			<td><button type="button" onclick="checkId()">아이디중복체크</button></td>
			<c:choose>
				<c:when test="${checked } == 'false' && ${id } != null">
					<td>중복된 아이디입니다.</td>
				</c:when>
				<c:when test="${checked } == 'true' && ${id } != null">
					<td>사용가능한 아이디입니다.</td>
				</c:when>
				<c:otherwise>
					<td>이게뜨나?</td>
				</c:otherwise>				
			</c:choose>
		</tr> --%>
		<tr>
			<th>비밀번호</th><td><input type="password" name="pw" class="form-control" value="${pw }" required></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th><td><input type="password" name="pwcheck" class="form-control" placeholder="아직 구현안됐지만 입력 해야함" required></td>
		</tr>
		<tr>
			<th>이미지</th><td><input type="file" name="myImg" class="form-control"></td>
		</tr>
		<tr>
			<td><button type="button" onclick="location.href='loginForm.do'">돌아가기</button></td>
			<td><button type="submit">회원가입</button></td>
		</tr>
	</table>
</form>

<script type="text/javascript">

	function checkId() {
		let id = document.querySelector('input[name=id]').value;
		alert(id);
		location.href='checkId.do?id='+id;
	}
</script>