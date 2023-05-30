var x = 'global';

function foo(){
    var x = 'local';
    console.log(x);
}

foo();

console.log(x);