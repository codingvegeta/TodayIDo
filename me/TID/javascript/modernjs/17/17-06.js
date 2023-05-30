function Circle(radius){

    console.log('this : ' + this);
    this.radius = radius;
    this.getDiameter = function(){
        return this.radius * 2;
    };
}

const circle3 = Circle(15);

console.log(circle3);

console.log(radius);

const circle4 = new Circle(10);

console.log(circle4);

console.log(radius);