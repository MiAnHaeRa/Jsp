/**
 * arr3.js
 */

// reduce
// acc - 누적값(?)
let sum = [10, 20, 30, 40, 50, 40, 30, 60, 20, 10].reduce(function(acc, ele, index, arr) {
	    console.log(acc, ele, index, arr);
	    if(ele > acc) {
			return ele;
		}
	    return acc;
	}, 0);
console.log("최댓값 : " + sum);

['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'].reduce(function(acc, ele) {
    let li = document.createElement('li');
    li.innerHTML = ele;
    acc.appendChild(li);

    return acc;
}, document.querySelector('#fruit'));