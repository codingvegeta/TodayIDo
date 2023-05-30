function foo(){
    console.log('global function foo');
}

function bar(){
    function foo(){
        console.log('local function foo');
    }
    foo();
}

bar();
