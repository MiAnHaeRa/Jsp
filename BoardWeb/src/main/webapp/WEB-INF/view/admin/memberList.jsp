<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- memberList.jsp -->
<h3>회원목록(관리자용)</h3>
<div style="width: 600px; text-align: center;">
	<table class="table" border="1">
		<!-- 회원아이디/ 이름/ 비밀번호/ 이미지 -->
		<tr>
			<th class="col-sm-2">아이디</th>
			<th class="col-sm-2">이름</th>
			<th class="col-sm-2">비밀번호</th>
			<th class="col-sm-5">프로필이미지</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td>${member.userId}</td>
				<td>${member.userName}</td>
				<td>${member.userPw}</td>
				<td>
					<c:choose>
						<c:when test="${empty member.img}">
							이미지 없음
							<!-- <img alt="이미지 없음" src=""> -->
						</c:when>
						<c:otherwise>
							<img width="50px" src="images/${member.img}" onclick="window.open( this.src)">
						</c:otherwise>
					</c:choose>
					<!-- <img width="200px" alt="이미지" src="${empty member.img ? '' : 'images/'.concat(member.img) }"> -->
				</td>
			</tr>
		</c:forEach>
	</table>
</div>