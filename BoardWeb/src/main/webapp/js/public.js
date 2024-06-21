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
    fetch(url)
    .then(result => result.json()   //[{"id":1, "center":...}]
    ).then(result => {
        AllData = result.data;
        console.log(result.data);
        result.data.forEach(center => {
            target.appendChild(makeRow(center));
            if(forAddrData.indexOf(center['sido']) == -1){
                forAddrData.push(center['sido']);
            }
        });
        console.log(forAddrData);
    });
}


function makeRow(center) {
    // console.log(center);
    let feilds = ['id', 'centerName', 'phoneNumber', 'address'];
    let tr = document.createElement('tr');
    feilds.forEach(feild => {
        let td = document.createElement('td');
        td.innerHTML = center[feild];
        tr.appendChild(td);
    });
    
    return tr;
}

function searchBtn() {
    let search = document.querySelector('#search');
    let cnt = 0;
    target.innerHTML="";
    AllData.forEach(center => {
        if(center.address.includes(search.value)) {
            cnt++;
            target.appendChild(makeRow(center));
        }
    })

    if(cnt == 0) {
        target.innerHTML = "<tr><td colspan='4'>검색 결과가 존재하지 않습니다</td></tr>";
    }
}