const x = 1;

function foo() {
    const x = 10;
    bar();
}

function bar(){
    console.log(x);
}

foo();
bar();
