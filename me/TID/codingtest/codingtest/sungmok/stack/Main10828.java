//package sungmok.stack;
//
//import org.w3c.dom.css.CSSImportRule;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * push X: 정수 X를 스택에 넣는 연산이다.
// * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// * size: 스택에 들어있는 정수의 개수를 출력한다.
// * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
// * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// */
//public class Main10828 {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Stack sungmok.stack = new Stack(sc.nextInt());
//        sungmok.stack.sc.next(10);
//        System.out.println(sungmok.stack.empty());
//        System.out.println("sungmok.stack.top() = " + sungmok.stack.top());
//
//    }
//}
//
//class Stack{
//    public Stack(int size) {
//        this.size = size;
//    }
//
//    int size;
//    int[] arraysStack = new int[size];
//    int tailPosition = 0;
//
//
//    public void push(int x) {
//        stackList.add(x);
//        ++tailPosition;
//    }
//
//    public int pop() {
//        if (stackList.get(tailPosition) > 0) {
//            return stackList.get(tailPosition--);
//        } else {
//            return -1;
//        }
//    }
//
//    public int size() {
//        return tailPosition;
//    }
//
//    public int empty() {
//        return tailPosition == 0 ? 1 : 0;
//    }
//
//    public int top() {
//        if (tailPosition > 0) {
//            return stackList.get(tailPosition - 1);
//        } else {
//            return -1;
//        }
//    }
//
//}
