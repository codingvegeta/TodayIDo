function Circle(radius) {
    if(!new.target){
        return new Circle(radius);
    }
    this.radius = radius;
    this.getDiameter = function() {
        return this.radius * 2;
    };
}

