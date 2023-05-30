function Circle(radius){
    if(!(this instanceof Circle)){
        return new Circle(radius);
    }

    this.radius = radius;
    this.getDiameter = function(){
        return this.radius * 2;
    };
}
