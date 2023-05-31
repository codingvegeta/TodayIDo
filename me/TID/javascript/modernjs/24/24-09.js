let num = 0;

const increase = function () {
    return num++;
}

console.log(increase());
console.log(increase());
console.log(increase());
// num 변수를 window , global 객체에서 가지고 있기 때문에 좋은 방법이 아니다.