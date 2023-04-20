package infrun.stack_que;

import java.util.*;

public class Sq2 {
    static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char x : str.toCharArray()){
            st.push(x);
            if (st.peek() == ')') {
                while (st.pop() != '(');
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
