<%@page import="java.util.List"%>
<%@page import="co.yedam.vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Main 페이지</h3>
	<%
		Student student =(Student)request.getAttribute("student");
		List<Student> list =(List<Student>) request.getAttribute("studentList");
	%>
	<p>학생번호 : <%=student.getStdNo() %></p>
	<p>학생이름 : <%=student.getStdName() %></p>
	<p>학생연락처 : <%=student.getPhone() %></p>

	<h3>학생 목록</h3>
	<ul>
	<% for(Student std : list) {%>
		<li>학번 : <%=std.getStdNo() %> 
		이름 :<a href="product.do?stdNo=<%=std.getStdNo() %>"><%=std.getStdName() %></a> 
		연락처 : <%=std.getPhone() %></li>
	<%}%>
	</ul>
	
	<form action="product.do" method="get">
		<label for="stdNo">조회할 학번 : </label>
		<input name="stdNo" required>
		<button type="submit">조회</button>
	</form>
	
</body>
</html>