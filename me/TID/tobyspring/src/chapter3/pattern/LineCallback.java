package chapter3.pattern;

public interface LineCallback<T>
{
    T doSomethingWithLine(String line, T value);

}
