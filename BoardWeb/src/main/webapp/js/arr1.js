/**
 * arr1.js
 * forEach, filter, map, reduce
 */

// forEach
const numArr = [23, 17, 6, 41, 30, 12];
numArr.forEach(function(ele, index, arr) {
    console.log(ele, index, arr);
});     //매개값으로 함수

//짝수의 합
let evenSum = function(ele, index, arr) {
    if(ele % 2 == 0 ) {
        result += ele;
    }
};

//홀수번째의 합
let oddSum = function(ele, index, arr) {
    if(index % 2 == 0 ) {
        result += ele;
    }
};

// 35보다 작은 값들의 합
let onder35 = function(ele, index, arr) {
    if(ele < 35 ) {
        result += ele;
    }
};

let result = 0;
numArr.forEach(evenSum);
console.log("짝수의 합은 : " + result);

result = 0;
numArr.forEach(oddSum);
console.log("홀수번째의 합은 : " + result);

result = 0;
numArr.forEach(onder35);
console.log("35미만의 합은 : " + result);

const dupArr = [10, 27, 32, 55, 27, 10];
const arr = [];

//중복된 값 제거
dupArr.forEach(function(ele) {
    if(arr.indexOf(ele) == -1) {
        arr.push(ele);
    }
});
console.log("arr의 배열 값 : " + arr);