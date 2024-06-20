/**
 * reply연습.js
 */

//댓글 -> li생성
function makeRow(reply ={}) {
    let fields =['replyNo', 'reply', 'replyer', 'replyDate'];
    let li = document.createElement('li');

    fields.forEach(field => {
        let span = document.createElement('span');
        span.innerHTML = reply[field];
        if(field == 'reply') {
            width = '4';
        } else if(field == 'replyDate') {
            width = '3';
        } else {
            width = '2';
        }
        span.setAttribute('class','col-sm-' + width);
        li.appendChild(span);
    });
    return li;
}

//형태 복사 =>.cloneNode(true)
function cloneRow(reply = {}) {
    let templete = document.querySelector('div.content > ul > li:nth-of-type(1)').cloneNode(true);
    // console.dir(templete);
    templete.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
    templete.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
    templete.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
    templete.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate;
    let btn = '<button type="button" class="btn btn-danger" onclick="delData(event)">삭제</button>';
    templete.querySelector('span:nth-of-type(5)').innerHTML = btn;

    return templete;
}

//한건삭제
function delData(e) {
    let delAjax = new XMLHttpRequest();
    let rno = e.target.parentNode.parentNode.querySelector('span:nth-of-type(1)').innerHTML;
    delAjax.open('get', 'removeReply.do?rno='+rno);
    delAjax.send();
    delAjax.onload = function () {
        let result = JSON.parse(delAjax.responseText);
        if(result.retCode == 'Success') {
            alert('삭제 성공!!');
            e.target.parentNode.parentNode.remove();
        } else if(result.retCode == 'SQLFail') {
            alert('프로그램 오류로 삭제 실패하였습니다.(SQL문)');
        } else {
            alert('데이터가 존재하지 않거나 프로그램 오류로 삭제 실패했습니다.');
        }
    };

}

const listAjax = new XMLHttpRequest();
listAjax.open('get', 'replyListJson.do?bno='+bno);
listAjax.send();
listAjax.onload = function() {
    let data = JSON.parse(listAjax.responseText);
    // console.log(data);
    data.forEach(reply => {
        // document.querySelector('.reply > .content > ul').appendChild(makeRow(reply));
        document.querySelector('.reply > .content > ul').appendChild(cloneRow(reply));
    });
};
