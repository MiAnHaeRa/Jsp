<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<h3>Main 페이지</h3>
	<p>학생번호 : ${student.stdNo }</p>
	<p>학생이름 : ${student.stdName }</p>
	<p>학생연락처 : ${student.phone }</p>

	<h3>학생 목록</h3>
	<ul>
	<c:forEach var="std" items="${studentList }">
		<li>학번 : ${std.stdNo } 
		이름 :<a href="product.do?stdNo=${std.stdNo }">${std.stdName }</a> 
		연락처 : ${std.phone }</li>
	</c:forEach>
	</ul>
	
	<form action="product.do" method="get">
		<label for="stdNo">조회할 학번 : </label>
		<input name="stdNo" required>
		<button type="submit">조회</button>
	</form>
	