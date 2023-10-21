package chapter6.pointcuttest;

public class Target implements TargetInterFace
{
    public void hello(){}
    public void hello(String a){}
    public int minus(int a, int b)throws RuntimeException { return 0;}
    public int plus(int a, int b) {return 0;}
    public void method(){}
}
