/*
 * dom1.js
*/
document.getElementById('fruit').style.display = 'none';

document.querySelector('table.table tr:nth-of-type(5)').setAttribute("align", "center");

//페이지 로딩하면서 회원 3명 출력
for(let list of myMembers)
document.querySelector('#memberList').appendChild(addRow(list));

let addBtn = document.querySelector('#addBtn');
let modifyBtn = document.querySelector('#modifyBtn');
let delBtn = document.querySelector('#delBtn');
let allSelectBox = document.querySelector('thead input[type="checkbox"]');


//추가버튼 클릭이벤트 등록
addBtn.onclick = addMemberFnc;
modifyBtn.onclick = modifyMemberFnc;
delBtn.onclick = removeMemberFnc;
allSelectBox.onchange = allCheckFnc;

function addMemberFnc() {
    const id = document.querySelector('#mid').value;
    const name = document.querySelector('#mname').value;
    const phone = document.querySelector('#mphone').value;
    const point = document.querySelector('#mpoint').value;

    if(!id || !name || !phone || !point) {
        alert("필수값을 입력해라");
        return;
    }

    document.querySelector('#memberList').appendChild(addRow({id, name, phone, point}));

    document.querySelector('#mid'). value = "";
    document.querySelector('#mname'). value = "";
    document.querySelector('#mphone'). value = "";
    document.querySelector('#mpoint'). value = "";
}

function addRow(member = {id, name, phone, point}) {
    // tr > td *4
    const tr = document.createElement('tr');
    tr.addEventListener('click', showDetailFnc);
    for(let prop in member) {
        const td = document.createElement('td');
        td.innerHTML = member[prop];
        tr.appendChild(td);
    }

    //삭제버튼 생성
    let td = document.createElement('td');
    let deleteBtn = document.createElement('button');
    deleteBtn.innerHTML = "삭제";
    deleteBtn.setAttribute("class", "btn btn-danger text-body")
    deleteBtn.addEventListener('click', removeTrElement)
    td.appendChild(deleteBtn);
    tr.appendChild(td);

    //체크박스 생성
    td = document.createElement('td');
    let checkBtn = document.createElement('input');
    checkBtn.setAttribute("type", "checkbox");
    checkBtn.addEventListener('click', checkAllCheck);
    td.appendChild(checkBtn);
    tr.appendChild(td);

    return tr;
}

function removeTrElement(e) {
    e.stopPropagation();    //상위요소로 이벤트 전파 차단
    this.parentNode.parentNode.remove();
}

function showDetailFnc(e) {
    console.log(e);
    // console.dir(this.children[0].innerHTML);
    let id = this.children[0].innerHTML;
    let name = this.children[1].innerHTML;
    let phone = this.children[2].innerHTML;
    let point = this.children[3].innerHTML;

    document.querySelector('#mid'). value = id;
    document.querySelector('#mname'). value = name;
    document.querySelector('#mphone'). value = phone;
    document.querySelector('#mpoint'). value = point;
}

function modifyMemberFnc() {
    //입력화면의 회원아이디값을 mid변수에 저장
    const mid = document.querySelector('#mid').value;
    const mname = document.querySelector('#mname').value;
    const mphone = document.querySelector('#mphone').value;
    const mpoint = document.querySelector('#mpoint').value;

    const trList = document.querySelectorAll('#memberList tr');
    for(let list of trList) {
        if(list.children[0].innerHTML == mid) {
            list.children[1].innerHTML = mname;
            list.children[2].innerHTML = mphone;
            list.children[3].innerHTML = mpoint;
            console.log("수정완료");

            document.querySelector('#mid'). value = "";
            document.querySelector('#mname'). value = "";
            document.querySelector('#mphone'). value = "";
            document.querySelector('#mpoint'). value = "";
        }
    }
}

function removeMemberFnc(e) {
    e.stopPropagation();
    const trList = document.querySelectorAll('#memberList tr');
    for(let list of trList) {
        if(list.children[5].children[0].checked) {
            list.remove();
        }
    }
    document.querySelector('thead input[type="checkbox"]').checked = false;
}

/*
 * this => 1. 이벤트(이벤트대상)
 *         2. function함수(Window)
 *         3. 객체(객체자신)
*/
function allCheckFnc(e) {
    // const trList = document.querySelectorAll('#memberList tr')
    //     .forEach(item => item.children[5].children[0].checked = this.checked);
    const trList = document.querySelectorAll('#memberList tr');
    for(let list of trList) {
        if(this.checked) {
            list.children[5].children[0].checked = true;
        } else {
            list.children[5].children[0].checked = false;
        }
    }
}

function checkAllCheck(e) {
    e.stopPropagation();
    let allCheckBox = document.querySelector('thead input[type="checkbox"]');
    //하나 해제할때 전체 체크 해제
    if(!this.checked) {
        allCheckBox.checked = false;
    }
    //모두 선택됐을때 전체 체크 설정
    let cnt = 0;
    const trList = document.querySelectorAll('#memberList tr');
    for(let i = 0; i < trList.length; i++) {
        if(trList[i].children[5].children[0].checked) cnt++;
    }
    if(cnt == trList.length) {
        allCheckBox.checked = true;
    }
}