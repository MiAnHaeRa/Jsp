<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:set var="name" value="hong"/>
<c:out value="${name == 'kong' ? '맞다' : '틀리다'}"></c:out>

<h3>로그인 화면(loginForm.jsp)</h3>
<myTag:line/>
<!-- JSP standard tag library (JSTL) -->
<form action="login.do" method="post" style="width:400px">
	<table class="table" border="1">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="userId"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="userPw"></td>
		</tr>
		<tr>
			<td><button type="submit">로그인</button></td>
			<td><button type="button" onclick="regist()">회원가입</button></td>
		</tr>
	</table>
</form>

<script type="text/javascript">
	function regist() {
		location.href="registForm.do";
	}
</script>
