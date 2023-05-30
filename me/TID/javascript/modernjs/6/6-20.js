var key = Symbol('key');

console.log(key);
console.log(typeof key);

var obj = {};

obj[key] = 'value';
console.log(obj);
console.log(obj[key]);