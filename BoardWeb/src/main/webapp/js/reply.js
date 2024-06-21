/**
 * reply.js
 */

/**목록 */
//목록
let page = 1;
svc.replyList({ bno, page }, replyListFnc);

//replyList의 매개값으로 사용될 함수
function replyListFnc() {
	//기존 5개의 목록 지우고 새롭게 출력
	document.querySelectorAll('div.content > ul > li').forEach((item, idx) => {
		if(idx > 2)
			item.remove();
	});
	let data = JSON.parse(this.responseText);
	data.forEach(reply => {
		document.querySelector('div.content > ul').appendChild(cloneRow(reply));
	});
	makePagingFuc();
};

//댓글등록
document.querySelector('#addReply').addEventListener('click', addReplyFuc);

// 등록실행함수 bno, replyer
function addReplyFuc() {
	if (!replyer) return alert("로그인후 댓글을 달아주세요!");
	let reply = document.querySelector('#reply');
	if (!reply.value) return alert("내용을 입력해주세요");
	svc.addReply({ replyer, reply: reply.value, bno }, addReplyCallBack);

	function addReplyCallBack() {
		//화면에 댓글출력
		console.log("1");
		let result = JSON.parse(this.responseText);
		if (result.retCode == 'Success') {
			alert(result.msg);
			//document.querySelector('div.content > ul').appendChild(cloneRow(result.retVal));
			//page = 1;
			svc.replyList({ bno, page : 1 }, replyListFnc);
			reply.value = "";
			reply.focus();
		} else {
			alert(result.msg);
		}
	}
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
			svc.replyList({ bno, page }, replyListFnc);
			//li.remove();
		} else if (result.retCode == 'SQLFail') {
			alert(result.msg);
		} else {
			alert(result.msg);
		}
	}
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


//페이징 a태그를 클릭하면 목록 보여주기
document.querySelectorAll('div.pagination a').forEach(item => {
	item.addEventListener('click', function(e) {
		e.preventDefault();
		page = item.innerHTML;
		svc.replyList({ bno, page }, replyListFnc);
	});
});

//댓글건수를 활용해서 페이징 계산하고 목록출력
function makePagingFuc() {
	svc.replyTotalCnt(bno, createPagingList);
};

let pagination = document.querySelector('div.pagination');
function createPagingList() {
	let totalCnt = this.responseText;		//632건 / 5 => 127페이지
	let startPage, endPage;
	let prev, next;
	let realEnd = Math.ceil(totalCnt / 5);	//127페이지
	
	endPage = Math.ceil(page / 10) * 10;	//10page
	startPage = endPage - 9;				//1페이지
	endPage = endPage > realEnd ? realEnd : endPage;
	
	prev = startPage > 1;
	next = endPage < realEnd;
	
	//startPage, endPage, prev, next => a태그 생성
	pagination.innerHTML = "";
	if(prev) {
		let aTag = document.createElement('a');
		aTag.setAttribute('href',"#");
		aTag.setAttribute('data-page', startPage-1);
		aTag.innerHTML = "&laquo;";
		pagination.appendChild(aTag);
	}
	
	for(let p = startPage; p <= endPage; p++) {
		let aTag = document.createElement('a');
		aTag.setAttribute('href',"#");
		aTag.setAttribute('data-page', p);
		aTag.innerHTML = p;
		if(page == p) {
			aTag.className = 'active';
		}
		pagination.appendChild(aTag);
	}
	
	if(next) {
		let aTag = document.createElement('a');
		aTag.setAttribute('href',"#");
		aTag.setAttribute('data-page', endPage+1);
		aTag.innerHTML = "&raquo;";
		pagination.appendChild(aTag);
	}
	
	document.querySelectorAll('div.pagination a').forEach(item => {
	item.addEventListener('click', function(e) {
		e.preventDefault();
		page = item.dataset.page;
		svc.replyList({ bno, page }, replyListFnc);
	});
});
	
};