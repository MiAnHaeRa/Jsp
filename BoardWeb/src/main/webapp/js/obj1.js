/**
 * obj1.js
 * id, first, email, salary
 */
document.querySelector('#dom').remove();

const obj = {
    data: '',
    fields: ['id', 'first_name', 'email', 'salary'],
    showList: function (arr = []) {
        arr.forEach((emp, index) => {
            if (index < 3)
                document.querySelector('#list').appendChild(this.makeRow(emp));
        });
    },
    makeRow(emp = {id, first_name, email, salary}) {
        let tr = document.createElement('tr');
        this.fields.forEach(field => {
            let td = document.createElement('td');
            td.innerHTML = emp[field];
            tr.appendChild(td);
        });
        return tr;
    }
};

obj.showList(employees);

//추가 버튼 눌렀을때 추가하기
let uaddBtn = document.querySelector('#uaddBtn');

uaddBtn.onclick = () => {
    let id = document.querySelector('#uid').value;
    let uname = document.querySelector('#uname').value;
    let uemail = document.querySelector('#uemail').value;
    let usalary = document.querySelector('#usalary').value;
    let insert = {
        id,
        first_name : uname,
        email : uemail,
        salary : usalary
    };
    obj.showList([insert]);
    // document.querySelector('#list').appendChild(this.makeRow(insert));
};

const today = new Date();
today.getFullYear();

Date.prototype.format = function() {
    let yy = this.getFullYear();
    let mon = this.getMonth() + 1;
    let dd = this.getDate();
    
    return yy + "-" + mon + "-" + dd;
}

console.log(today.format());