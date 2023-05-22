const {odd, even} = require('./var');
const checkNumber = require('./func');

function checkStringOddOrEven(str) {
    if (str.length % 2) {
        return odd;
    }
    return even;
}

console.log(checkNumber(10));
console.log(6 % 2);
console.log(checkStringOddOrEven('hello!'));