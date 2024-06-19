/**
 * ajax3.js
 */

//목록 가져오기
const xhtp = new XMLHttpRequest();
xhtp.open('get', 'membersAjax.do');
xhtp.send();
xhtp.onload = function () {
    // console.log(xhtp);
    let data = JSON.parse(xhtp.responseText);
    console.log(data);
    data.forEach(user => {
        document.querySelector('#list').appendChild(makeRow(user));
    })
};

//json 문자열의 필드명을 활용
const fields = ['userId', 'userName', 'userPw', 'responsibility'];
function makeRow(obj = {}) {
    let tr = document.createElement('tr');
    tr.setAttribute('id', obj.userId);
    tr.addEventListener('dblclick', function(e) {
        document.getElementById('myModal').style.display = 'block';
        //선택된 사용자의 이름, 비번을 모달에 출력
        console.log(e, this);
        document.getElementById('modify_id').value = this.children[0].innerHTML;
        document.getElementById('modify_name').value = this.children[1].innerHTML;
        document.getElementById('modify_pass').value = this.children[2].innerHTML;
        
    })
    fields.forEach(field => {
        let td = document.createElement('td');
        td.innerHTML = obj[field];
        tr.appendChild(td);
    });

    let td = document.createElement('td');
    let btn = document.createElement('button');
    btn.setAttribute('type', 'button');
    btn.setAttribute('id', 'trDelBtn');
    btn.setAttribute('class', 'btn btn-danger');
    btn.setAttribute('onclick', 'DeleteMember');
    btn.innerText = "삭제";
    td.appendChild(btn);
    tr.appendChild(td);

    return tr;
}

document.querySelector('#modifyBtn').addEventListener('click', function() {
    let id = document.querySelector('#modify_id').value;
    let name = document.querySelector('#modify_name').value;
    let pw = document.querySelector('#modify_pass').value;

    // ajax 생성
    //정상적으로 정보가 업데이트되면 화면 수정
    //수정이 안됐으면 화면수정 X
    let updateAjax = new XMLHttpRequest();
    let url = "updateAjax.do?id="+id+"&name="+name+"&pw="+pw;
    updateAjax.open('get',url);
    updateAjax.send();
    updateAjax.onload = function() {
        let result = JSON.parse(updateAjax.responseText);
        if(result.retCode == "Completed") {
            let targetTr = document.querySelector('#' + id);
            targetTr.children[1].innerHTML = name;
            targetTr.children[2].innerHTML = pw;
            alert("업데이트 성공");
        } else {
            alert("업데이트 실패");
        }
    }
    
    //modal창 닫기
    document.querySelector('#myModal').style.display = 'none';
});

document.querySelector('#addBtn').addEventListener('click', function () {
    let id = document.querySelector('#uid');
    let pw = document.querySelector('#upw');
    let name = document.querySelector('#uname');
    let auth = document.querySelector('#auth');

    const addAjax = new XMLHttpRequest();
    let url = "addAjax.do?uid=" + id.value + "&upw=" + pw.value + "&uname=" + name.value + "&auth=" + auth.value;
    addAjax.open('get', url);
    addAjax.send();
    addAjax.onload = function () {
        let result = JSON.parse(addAjax.responseText);
        if (result.retCode == "OK") {
            let newMem = {
                userId: id.value,
                userName: name.value,
                userPw: pw.value,
                responsibility: auth.value
            }
            alert(result.retMsg);
            document.querySelector('#list').appendChild(makeRow(newMem));
            id.value = "";
            pw.value = "";
            name.value = "";
            auth.value = "User";
        } else {
            alert(result.retMsg);
        }
    }

});

document.querySelector('#uid').addEventListener('change', function() {
    let id = this;

    const checkAjax = new XMLHttpRequest();
    let url = "checkIdAjax.do?id=" + id.value;
    checkAjax.open('get', url);
    checkAjax.send();
    checkAjax.onload = function() {
        let result = JSON.parse(checkAjax.responseText);
        if(result.retCode == "Exist") {
            alert("이미 사용중인 아이디입니다.");
            document.querySelector('#addBtn').disalbled = true;
            id.focus();
        } else {
            alert("사용 가능한 아이디입니다.");
            document.querySelector('#addBtn').disalbled = false;
        }
    };
});

document.querySelector('#deleteBtn').addEventListener('click', function() {
    let id = document.querySelector('#uid');


    const deleteAjax = new XMLHttpRequest();
    let url = "deleteAjax.do?id="+id.value;
    deleteAjax.open('get', url);
    deleteAjax.send();
    deleteAjax.onload = function() {
        let result = JSON.parse(deleteAjax.responseText);
        if(result.retCode == "Deleted") {
            alert("계정 삭제가 완료되었습니다.");
            document.querySelectorAll('#list>tr').forEach((ele) => {
                if(ele.childNodes[0].innerText == id.value){
                    ele.remove();
                    id.value = "";
                }
            });
        }
    };
});

function DeleteMember() {

}