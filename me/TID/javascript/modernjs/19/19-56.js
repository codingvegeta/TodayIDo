function Person (name){
    this.name = name;
}

Person.prototype.sayName = function(){
    console.log(`Hi my name is ${this.name}`);
}

Person.kkProp = 'static prop';

Person.helloMethod = function(){
    console.log('Hello');
    };

const me = new Person('Me');

Person.helloMethod();
console.log(Person.kkProp);

// me.helloMethod(); 인스턴스에는 메서드가 존재 하지 않음 클래스 영역에 존재하는 느낌으로 있는거임


