/**
 * reply.js
 */

//목록
svc.replyList(bno, replyListFnc);

//댓글등록
document.querySelector('#addReply').addEventListener('click', addReplyFuc);

// 등록실행함수 bno, replyer
function addReplyFuc() {
    if(!replyer) return alert("로그인후 댓글을 달아주세요!");
    let reply = document.querySelector('#reply');
    if(!reply.value) return alert("내용을 입력해주세요");
    svc.addReply({replyer, reply:reply.value, bno}, addReplyCallBack);
    
    function addReplyCallBack() {
        //화면에 댓글출력
        console.log("1");
        let result = JSON.parse(this.responseText);
        if(result.retCode == 'Success') {
            alert(result.msg);
            document.querySelector('div.content > ul').appendChild(cloneRow(result.retVal));
            reply.value = "";
            reply.focus();
        } else {
            alert(result.msg);
        }
    }
}

//replyList의 매개값으로 사용될 함수
function replyListFnc() {
    let data = JSON.parse(this.responseText);
    data.forEach(reply => {
        document.querySelector('div.content > ul').appendChild(cloneRow(reply));
    });
};

//댓글정보 -> li 생성
function cloneRow(reply = {}) {
    let templete = document.querySelector('div.content > ul > li:nth-of-type(1)').cloneNode(true);
    // console.dir(templete);
    templete.setAttribute('delId', reply.replyNo);
    templete.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
    templete.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
    templete.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
    templete.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate;
    let btn = '<button type="button" class="btn btn-danger" onclick="delData(event)">삭제</button>';
    templete.querySelector('span:nth-of-type(5)').innerHTML = btn;

    return templete;
};

//한건삭제
function delData(e) {
    let rno = e.target.parentNode.parentNode.querySelector('span:nth-of-type(1)').innerHTML;
    let li = e.target.parentNode.parentNode;
    svc.removeReply(rno, replyDel);
    
    //removeReply메소드의 매개값으로 전달될 함수. 화면에서 한건 지우기
    function replyDel() {
        let result = JSON.parse(this.responseText);
        if (result.retCode == 'Success') {
            alert(result.msg);
            li.remove();
        } else if (result.retCode == 'SQLFail') {
            alert(result.msg);
        } else {
            alert(result.msg);
        }
    }
}