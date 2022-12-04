package org.example;

public class Cooking {
    public Cook makeCook(MenuItem menuItem) {
        Cook cook = new Cook(menuItem);
        return new Cook("돈까스", 5000);
    }

}
