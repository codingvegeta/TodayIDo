(function () {
    const foo = () => console.log(this);
    foo();
}).call({ a : 1 });

(function() {
    const bar = () => () => console.log(this);
    bar()();
}).call({ a : 1 });
