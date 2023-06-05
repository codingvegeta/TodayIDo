function sleep(func, delay){

    const delayUntil = Date.now() + delay;

    while (Date.now() < delayUntil);

    func();
}

function foo() {
    console.log('foo');
}

function bar() {
    console.log('bar');
}

sleep(foo, 3 * 1000);

bar();