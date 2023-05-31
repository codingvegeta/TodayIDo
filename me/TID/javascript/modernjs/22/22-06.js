const foo = function(){
    console.dir(this);
}

foo();

console.log('-----------');
const obj = { foo };
obj.foo();

new foo();

const bar = {name: 'zar'};

foo.call(bar);
foo.apply(bar);
foo.bind(bar)();
