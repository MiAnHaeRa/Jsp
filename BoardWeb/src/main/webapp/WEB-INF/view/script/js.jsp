<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- script/js.jsp -->
<h3>자바스크립트 연습</h3>

<ul id = fruit>
    <li>apple</li>
    <li>banana</li>
</ul>

<table class="table">
    <tr>
        <th>회원아이디</th><td><input type="text" id="mid"></td>
    </tr>
    <tr>
        <th>회원이름</th><td><input type="text" id="mname"></td>
    </tr>
    <tr>
        <th>회원연락처</th><td><input type="text" id="mphone"></td>
    </tr>
    <tr>
        <th>회원점수</th><td><input type="text" id="mpoint"></td>
    </tr>
    <tr>
        <td colspan="2">
            <button type="button" id="addBtn" class="btn btn-primary">추가</button>
            <button type="button" id="modifyBtn" class="btn btn-warning">수정</button>
            <button type="button" id="delBtn" class="btn btn-danger">선택삭제</button>
        </td>
    </tr>
</table>

<table class="table">
    <thead>
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>연락처</th>
            <th>포인트</th>
            <th>삭제</th>
            <th>모두선택<input type="checkbox"></th>
        </tr>
    </thead>
    <tbody id="memberList"></tbody>
</table>

<script src="js/data.js"></script>
<script src="js/dom1.js"></script>