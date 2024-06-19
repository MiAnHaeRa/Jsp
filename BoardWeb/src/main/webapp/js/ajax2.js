/**
 * ajax2.js
 * XMLHttpRequest 객체
 */

const xhtp = new XMLHttpRequest();
//데이터 받는 방식, 경로
xhtp.open('get', 'data/MOCK_DATA.json');
xhtp.send();
xhtp.onload = function() {
    //json문자열 -> js의 객체로 바꿔줌
    let data = JSON.parse(xhtp.responseText);
    // console.log(data);
    //DOM 활용해서 페이지 작성
    data.forEach(function(ele) {
        console.log(ele);
        document.querySelector('#list').appendChild(makeRow(ele));
    });
};

let fields = ['id', 'first_name', 'email', 'salary'];
function makeRow(obj={}) {
    let tr = document.createElement('tr');
    fields.forEach(field => {
        let td = document.createElement('td');
        td.innerHTML = obj[field];
        tr.appendChild(td);
    });

    return tr;
}

const xhtm = new XMLHttpRequest();
xhtm.open('get', 'loginForm.do');
xhtm.send();
xhtm.onload = function() {
    console.log(xhtm);
    // document.querySelector('#show').innerHTML = xhtm.responseText;
};

console.log("end");