const increase = function (num) {
    return ++num;
};

const decrease = function (num) {
    return --num;
};

const aux =  {increase ,decrease}

console.log(aux);

function makeCounter(aux) {
    let num = 0;

    return function () {
        num = aux(num);
        return num;
    }
};

console.log(makeCounter);

const increaser = makeCounter(aux.increase);
console.log(increaser());
console.log(increaser());

const decreaser = makeCounter(aux.decrease);
console.log(decreaser());
console.log(decreaser());