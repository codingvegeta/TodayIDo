const arr = [1,2,3];
arr.x = 10;

console.log(arr);

for(const i in arr){
    console.log(arr[i]);
}

for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
}

arr.forEach(v => console.log(v));

for (const value of arr) {
    console.log(value);
}
