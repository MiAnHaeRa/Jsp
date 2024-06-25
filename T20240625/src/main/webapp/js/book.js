/**
 * obj1.js
 */
showList();

//목록
function showList() {
    document.querySelector('#listBody').innerHTML = "";
    fetch("bookListJson.do")
        .then(result => result.json())
        .then(result => {
            result.forEach(books => {
                document.querySelector('#listBody').appendChild(makeRow(books));
            })
        })
}

//줄 추가(만들기)
fields = ['bookCode', 'bookTitle', 'author', 'company', 'price'];
function makeRow(books) {
    let tr = document.createElement('tr');
    //체크박스
    let td = document.createElement('td');
    let checkbox = document.createElement('input');
    checkbox.type = 'checkbox';
    checkbox.addEventListener('change', checking);
    td.appendChild(checkbox);
    tr.appendChild(td);

    //데이터 출력
    fields.forEach(field => {
        td = document.createElement('td');
        td.innerHTML = books[field];
        tr.appendChild(td);
    })

    //삭제버튼
    td = document.createElement('td');
    let delbtn = document.createElement('button');
    delbtn.type = 'button';
    delbtn.className = "btn btn-danger";
    delbtn.innerText = "삭제";
    delbtn.addEventListener('click', delRow);
    td.appendChild(delbtn)
    tr.appendChild(td);

    return tr;
}
//항목 체크
function checking(e) {
    //시간된다면 전체 선택되거나 해제시 타이틀쪽 체크 true/false 전환
    console.log(e);
}
//항목 삭제
function delRow(e) {
    // console.log(e.target.parentNode.parentNode);
    let tr = e.target.parentNode.parentNode;
    let bookCode = tr.children[1].innerText;
    if (removeBook(bookCode)) {
        alert("도서번호 '" + bookCode + "' 도서를 삭제하였습니다.");
        showList();
    } else {
        alert("도서번호 '" + bookCode + "' 삭제에 실패하였습니다.");
    }
}

//도서삭제
async function removeBook(bookCode) {
    await fetch('removeBook.do?code=' + bookCode)
        .then(result => result.json())
        .then(result => {
            if (result.retCode == "OK") {
                return true;
            } else {
                return false;
            }
        })
}

//도서추가
document.querySelector('#saveBtn').addEventListener('click', function () {
    let code = document.querySelector('#code');
    let title = document.querySelector('#title');
    let author = document.querySelector('#author');
    let company = document.querySelector('#company');
    let price = document.querySelector('#price');

    fetch('addBook.do?code=' + code.value +
        '&title=' + title.value +
        '&author=' + author.value +
        '&company=' + company.value +
        '&price=' + price.value)
        .then(result => result.json())
        .then(result => {
            if (result.retCode == "OK") {
                alert("도서 저장이 완료되었습니다.");
                code.value = "";
                title.value = "";
                author.value = "";
                company.value = "";
                price.value = "";
                showList();
            } else {
                alert("도서 저장에 실패하였습니다.");
                price.focus();
            }
        })
});

//전체선택
document.querySelector('#allCheck').addEventListener('change', function () {
    let boxes = document.querySelectorAll('#listBody > tr > td:nth-of-type(1) > input');
    if (this.checked == true) {
        for (let box of boxes) {
            box.checked = true;
        }
    } else {
        for (let box of boxes) {
            box.checked = false;
        }
    }
});

//선택삭제
document.querySelector('#delBtn').addEventListener('click', function () {
    let boxes = document.querySelectorAll('#listBody > tr > td:nth-of-type(1) > input');
    let delList = [];
    let cnt = 0;
    for (let box of boxes) {
        if (box.checked == true) {
            delList.push(box.parentNode.parentNode.childNodes[1].innerText);
        }
    }
    if (delList.length != 0) {
        delList.forEach(bookCode => {
            if(removeBook(bookCode)) {
                cnt++;
            } else {
                return alert("삭제 도중 오류가 발생되었습니다.");
            }
        });
        alert("전체 '" + cnt + "' 건의 책을 삭제하였습니다.");
        document.querySelector('#allCheck').checked = false;
        showList();
    } else if (delList.length == 0) {
        alert("삭제할 도서가 없습니다.");
    }
})