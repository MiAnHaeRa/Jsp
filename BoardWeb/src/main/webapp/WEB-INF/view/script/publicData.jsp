<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- publicData.jsp -->
 <h3>공공데이터 연습</h3>
 <div id="searchDiv">
    <label for="search">검색어(주소)</label>
    <input type="text" name="search" id="search" placeholder="ex)동구">
    <button type="button" class="btn btn-primary" onclick="searchBtn()">검색</button>
    <select name="sidoSelect" id="sidoSelect">
    	<option value="">전체보기</option>
    </select>
    <button type="button" id="centerDB">센터DB생성</button>
 </div>
<table class="table">
    <thead>
        <tr>
            <th class="col-sm-1">센터ID</th>
            <th class="col-sm-3">센터명</th>
            <th class="col-sm-2">센터연락처</th>
            <th class="col-sm-5">주소</th>
        </tr>
    </thead>
    <tr id="trTemp" style="display: none;">
        <td>센터ID</td>
        <td>센터명</td>
        <td>센터연락처</td>
        <td>주소</td>
    </tr>
    <tbody id="centerList"></tbody>
</table>
<script src="js/public.js"></script>