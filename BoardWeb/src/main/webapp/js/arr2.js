/**
 * arr2.js
 */

//filter
// [A,A,A] => [A,A]
let result = [23, 45, 22, 39, 10, 56].filter(function(ele, index, arr) {
    if(ele % 2 == 0) {
        return ele;
    }
});
// console.log(result);
// employees.forEach(console.log);

//급여가 5000이 넘는 여자만 필터링
let over5000Sum = 0;
let filterFuc = emp => emp.salary > 5000 && emp.gender == "Female";
let over5000 = employees.filter(function(ele) {
    if(ele.salary > 5000 && ele.gender == "Female") {
        return ele;
    }
});
over5000 = employees.filter(filterFuc);
console.log(over5000);

employees.filter(filterFuc).forEach(element => {
    over5000Sum += element.salary;
});
console.log("조건 만족한 사람의 급여 합 : " + over5000Sum);

//map
// [A,A,A] => ['A','A','A']
employees.map(function(ele, index, arr) {
    const obj = {};
    obj.name = ele.first_name + "-" + ele.last_name;
    obj.number = ele.id;
    obj.salary = ele.salary;
    return obj;
    }).forEach(console.log);