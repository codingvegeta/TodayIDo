package beakjoon.doit.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                stack.push(i);
            } else {
                if (stack.peek() + 1 == i) {
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
