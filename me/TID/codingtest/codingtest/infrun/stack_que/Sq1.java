package infrun.stack_que;

import java.util.Scanner;
import java.util.Stack;

public class Sq1 {
    static String solution(String str) {
        String answer = "YES";
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<str.length(); i++){
            char x = str.charAt(i);
            if (x == '(') {
                st.push('(');
            } else {
                if (st.isEmpty()) {
                    return "NO";
                }
                st.pop();
            }
        }
        if (!st.isEmpty()) return "NO";
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
