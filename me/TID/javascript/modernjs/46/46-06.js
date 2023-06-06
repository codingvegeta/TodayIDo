function* genfunc(){
    try{
        yield 1;
        yield 2;
        yield 3;
    }catch(e){
        console.error(e);
    }
}

const generator = genfunc();

console.log(generator);
console.log(generator.next());
console.log(generator.return('End!'));
console.log(generator);