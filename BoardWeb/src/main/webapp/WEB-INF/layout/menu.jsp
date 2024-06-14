<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="border-end bg-white" id="sidebar-wrapper">
<c:choose>
 		<c:when test="${logId == null }">
 		<div class="sidebar-heading border-bottom bg-light">Start Bootstrap<br>(Guest)</div>
	</c:when>
	<c:otherwise>
 		<div class="sidebar-heading border-bottom bg-light">Start Bootstrap<br>(${logId })</div>
	</c:otherwise>
 </c:choose>
 <div class="list-group list-group-flush">
     <a class="list-group-item list-group-item-action list-group-item-light p-3" href="main.do">메인페이지</a>
     <a class="list-group-item list-group-item-action list-group-item-light p-3" href="StudentForm.do">학생정보등록</a>
     <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">자유게시판</a>
     <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">이건 템플릿</a>
     <c:choose>
     	<c:when test="${logId == null }">
          <a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인</a>
        	</c:when>
        	<c:otherwise>
          <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃</a>
        	</c:otherwise>
        </c:choose>
    </div>
</div>