console.dir(add);
console.dir(functions);

console.log(add(1,2));
// console.log(functions(1,2));



function add(a, b) {
    return a+b;
}

var functions = function (a,b) {
    return a+b;
}

//위의 2가지 함수는 생성되는 시점이 다르다.
// 자바 스크립트는 동적 언어이기 때문에 타입을 정의하지 않는다.
// 이 경우 함수를 만들 때  예상하지 않은 방향으로 작성될 수 있다.
// ex
console.log(add('a','b')); // ab 가 된다.
