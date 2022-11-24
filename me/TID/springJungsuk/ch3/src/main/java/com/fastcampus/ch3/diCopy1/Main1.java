package com.fastcampus.ch3.diCopy1;

import java.io.FileReader;
import java.util.Properties;

class Car{}
class SportsCar extends Car{}
class Truck extends Car{}
class Engine{}


public class Main1 {
    public static void main(String[] args) throws Exception {
        Car car = (Car) getObject("car");
        System.out.println("car = " + car);
        Engine engine = (Engine) getObject("engine");
        System.out.println("engine = " + engine);
    }

    static Object getObject(String key) throws Exception{
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty(key));

        return clazz.newInstance();
    }
    static Car getCar() throws Exception{
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty("car"));

        return (Car) clazz.newInstance();
    }
}
