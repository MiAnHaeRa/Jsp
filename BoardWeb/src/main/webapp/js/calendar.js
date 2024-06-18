/*
 * calendar.js
*/
// 기초작업
document.querySelectorAll('.container-fluid h3').forEach(item => item.remove());
document.querySelectorAll('.container-fluid table.table').forEach(item => item.remove());
document.querySelectorAll('#fruit').forEach(item => item.remove());

//오늘 날짜
let today = new Date();
let todayMonth = today.getMonth() + 1;
let todayDate = today.getDate();

document.querySelector('#selectMonth').addEventListener("change", function() {
    makeCalendar(parseInt(this.value));
});

makeCalendar(todayMonth);

//달력의 첫째날을 계산하는 함수, 마지막날 계산 함수
function getFirstDay(month = 6) {
    switch(month) {
        case 5:
            return 4;
        case 7:
            return 2;
        
    }
    return 7;
}

function getLastDate(month = 6) {
    switch(month) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            return 31;
        case 4: case 6: case 9: case 11:
            return 30;
    }
    return 30;
}

function makeCalendar(month = 6) {
    document.querySelector('#show').innerHTML = "";
    let firstDay = getFirstDay(month);  //1일의 위치 지정하기 위한 공란의 갯수 반환
    let lastDate = getLastDate(month);  //원읠 마지막날 반환

    // table생성 border="2"
    let tbl = document.createElement('table');
    tbl.setAttribute('border', "2");
    tbl.setAttribute('class', "table");
    tbl.setAttribute('style', "width:600px;");
    let thd = document.createElement('thead');
    let tbd = document.createElement('tbody');

    //thead 하위요소
    let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
    let tr = document.createElement('tr');
    days.forEach(day => {
        let th = document.createElement('th');
        th.innerHTML = day;
        th.setAttribute('style','background-color: rgb(129, 247, 125);');
        tr.appendChild(th);
    });
    thd.appendChild(tr);

    //tbody 하위요소
    //앞 공백
    tr = document.createElement('tr');
    for(let i = 1; i < firstDay; i++) {
        let td = document.createElement('td');
        tr.appendChild(td);
    }
    //실제 날짜
    for(let d = 1; d <= lastDate; d++) {
        let td = document.createElement('td');
        // 토요일
        if((d + firstDay - 1) % 7 == 0) {
            td.setAttribute('style', 'background-color : blue; color : white;');
        }
        // 일요일
        if((d + firstDay - 1) % 7 == 1) {
            td.setAttribute('style', 'background-color : red; color : white;');
        }
        // 오늘
        if(d == this.todayDate) {
            td.setAttribute('style', 'background-color: rgb(244, 255, 150); color : black;');
        }
        td.innerHTML = d;
        tr.appendChild(td);
        if((d + firstDay - 1) % 7 == 0) {  //7일마다 줄바꿈
            tbd.appendChild(tr);
            tr = document.createElement('tr');
        }
    }
    tbd.appendChild(tr);

    tbl.appendChild(thd);
    tbl.appendChild(tbd);

    document.querySelector('#show').appendChild(tbl);
}

// makeCalendar(6);