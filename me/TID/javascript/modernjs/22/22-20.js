function getThisBinding(){
    console.log(arguments);
    return this;
}

const thisArg = {a:1};

const asd = getThisBinding.apply(thisArg,[1,2,3]);
console.log(getThisBinding.apply(thisArg,[1,2,3]));
console.log(getThisBinding);
console.log(thisArg);
console.log('asd = ',asd);

console.log(getThisBinding.call(thisArg,1,2,3));
