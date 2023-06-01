class Person {
    constructor(name){
        console.log(this);
        console.log(Object.getPrototypeOf(this) === Person.prototype);

        this.name = name;
    }
}

const me = new Person('hong');
