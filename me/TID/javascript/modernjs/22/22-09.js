var value = 1;

const obj = {
    value : 100,
    foo() {
        console.log('foo\'s this : ', this);
        console.log('foo\'s this.value : ', this.value);

        function bar() {
            console.log('bar\'s this : ',this);
            console.log('bar\'s this.value : ', this.value);
        }

        bar();
    }
};

obj.foo();