<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../public/header.jsp"%>

<h3>학생등록화면</h3>
<%
	String msg =(String) request.getAttribute("message");
%>
<%
	if(msg != null) {
%>
	<p><%=msg %></p>
<%} %>
<!-- 
<form action="addStudent.do" method="post">
	<label for="stdNo">학번</label> <input type="text" name="stdNo" required>
	<label for="stdName">이름</label> <input type="text" name="stdName"
		required> <label for="phone">연락처</label> <input type="text"
		name="phone" required> <label for="bldType">혈액형</label> <input
		type="text" name="bldType" required>
	<button type="submit">등록하기</button>
</form>
 -->

<form action="addStudent.do" method="post">
	<table class="table" style="width:350px">
		<tr>
			<th>학생번호</th>
			<td><input type="text" name="stdNo" required></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="stdName" required></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name="phone" required></td>
		</tr>
		<tr>
			<th>혈액형</th>
			<td><input type="text" name="bldType" required></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="등록하기" class="btn btn-primary"></td>
		</tr>
	</table>
</form>
<%@include file="../public/footer.jsp"%>