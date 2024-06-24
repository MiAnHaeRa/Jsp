/**
 * public.js
 */

let url = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=dVHh35ke9WltA%2F0%2FotQmHk%2FrG6l0S1afJylSXFf6bwezd8%2FJKagZoCLBiB%2FEsUoNlcwvh%2BxK5GG5Bm4Vhh53yw%3D%3D";

const target = document.querySelector('#centerList');
let AllData;
let forAddrData = [];
dataCall();
setTimeout(dataCall(), 300000);

function dataCall() {
    fetch(url)  //promise 객체로 반환
        .then(result => result.json()   //[{"id":1, "center":...}]
        ).then(result => {
            AllData = result.data;
            console.log(result.data);
            result.data.forEach(center => {
                target.appendChild(makeRow(center));
                if (forAddrData.indexOf(center['sido']) == -1) {
                    forAddrData.push(center['sido']);
                }
            });
            forAddrData.forEach(sido => {
                let option = document.createElement('option');
                option.innerText = sido;
                option.value = sido;
                document.querySelector('#sidoSelect').appendChild(option);
            })
                .catch(err => console.log(err))
        });
};


function makeRow(center) {
    // console.log(center);
    let feilds = ['id', 'centerName', 'phoneNumber', 'address'];
    let tr = document.createElement('tr');
    feilds.forEach(feild => {
        let td = document.createElement('td');
        td.innerHTML = center[feild];
        tr.appendChild(td);
    });
    tr.addEventListener('click', function () {
        // location.href="map.do?x="+center.lat+"&y="+center.lng;
        window.open("map.do?x=" + center.lat + "&y=" + center.lng + "&name=" + center.centerName);
    });

    return tr;
};

function searchBtn() {
    let search = document.querySelector('#search').value;
    let cnt = 0;
    target.innerHTML = "";
    AllData.forEach(center => {
        if (center.address.includes(search.value)) {
            cnt++;
            target.appendChild(makeRow(center));
        }
    })

    if (cnt == 0) {
        target.innerHTML = "<tr><td colspan='4'>검색 결과가 존재하지 않습니다</td></tr>";
    }
};

function searchSelect(value) {
    let cnt = 0;
    target.innerHTML = "";
    AllData.forEach(center => {
        if (center.sido.includes(value)) {
            cnt++;
            target.appendChild(makeRow(center));
        }
    });
};

document.querySelector('#sidoSelect').addEventListener('change', function () {
    searchSelect(this.value);
});

document.querySelector('#centerDB'); addEventListener('click', createCenterInfo);

function createCenterInfo(e) {
    e.stopPropagation();
    //1. api호출 -> fetch
    //2. 컨트롤 호출 DB입력
    fetch(url)
        .then(result => result.json())
        .then(result => {
            let centers = result.data; //{},{},{}
            return fetch('centerInfo.do', {
                method: 'post',      //전달되는 값이 body영역에 저장
                headers: {'Content-Type': 'application/json'},   //키 = 값& 키 = 값
                body: JSON.stringify(centers)   //객체 -> json 문자열
            })
                .then(result => result.json())
                .then(result => {
                    if(result.txtCnt > 0){
                        alert(result.txtCnt + ' 건 처리 성공');
                    } else {
                        alert('실패');
                    }
                })
                .catch(err => console.log(err));
        })
        .catch(err => console.log(err));
}