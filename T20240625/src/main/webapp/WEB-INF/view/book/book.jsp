<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- 화면(book) -->
    <style>
        #inputTable {
            margin: 0 auto;
            text-align: center;
            width: 60%;
        }
        #inputTable th {
            background-color: rgb(255, 255, 0);
        }
        #inputTable button {
            width: 70%;
        }

        #listTable {
            margin: 0 auto;
            text-align: center;
        }
        #listTable th {
            background-color: #666;
            color: white;
        }
    </style>
    <br>
    <table class="table" id="inputTable" border="1">
        <tr>
            <th class="col-sm-2">도서코드</th>
            <td class="col-sm-7"><input type="text" id="code" class="form-control"></td>
            <td class="col-sm-2"></td>
        </tr>
        <tr>
            <th class="col-sm-2">도서명</th>
            <td class="col-sm-7"><input type="text" id="title" class="form-control"></td>
            <td class="col-sm-2"><button type="button" id="saveBtn" class="btn btn-primary">저장</button></td>
        </tr>
        <tr>
            <th class="col-sm-2">저자</th>
            <td class="col-sm-7"><input type="text" id="author" class="form-control"></td>
            <td class="col-sm-2"></td>
        </tr>
        <tr>
            <th class="col-sm-2">출판사</th>
            <td class="col-sm-7"><input type="text" id="company" class="form-control"></td>
            <td class="col-sm-2"><button type="button" id="delBtn" class="btn btn-danger">선택삭제</button></td>
        </tr>
        <tr>
            <th class="col-sm-2">금액</th>
            <td class="col-sm-7"><input type="text" id="price" class="form-control"></td>
            <td class="col-sm-2"></td>
        </tr>
    </table>
    <br>
    <table class="table" id="listTable" border="1">
        <thead>
            <tr>
                <th class="col-sm-1"><input type="checkbox" id="allCheck"></th>
                <th class="col-sm-1">도서코드</th>
                <th class="col-sm-3">도서명</th>
                <th class="col-sm-1">저자</th>
                <th class="col-sm-2">출판사</th>
                <th class="col-sm-1">가격</th>
                <th class="col-sm-1">삭제</th>
            </tr>
        </thead>
        <tbody id="listBody"></tbody>
    </table>

    <script src="js/book.js"></script>