//DOM 연습
document.querySelector('ul#fruit > li').innerHTML = "사과";
//Li 생성
let li = document.createElement('li');  //<li></li>
li.innerHTML = "<b>오렌지</b>";     //<li><b>오렌지</b></li>

document.querySelector('ul#fruit').appendChild(li);
document.querySelector('ul#fruit > li').remove();
document.querySelector('ul#fruit > li').style.backgroundColor = "yellow";

//button 생성
let lists = document.querySelectorAll('ul#fruit > li');
for (let list of lists) {
	let btn = document.createElement('button');
	btn.innerHTML = "삭제";
	btn.setAttribute("class", "btn btn-primary");
	btn.addEventListener('click', function() {
		btn.parentNode.remove();
	}); //이벤트유형, 실행코드
	list.appendChild(btn);
}