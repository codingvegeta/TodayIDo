const array = [1 ,2, 3 ];

const iterator = array[Symbol.iterator]();

console.log(iterator);
console.log(array[Symbol.iterator]);

console.log(iterator.next());
console.log(iterator.next());
console.log(iterator.next());
console.log(iterator.next());