package infrun.stack_que;

import java.util.Scanner;
import java.util.Stack;

public class Sq4 {
    static int solution(String str) {
        Stack<Integer> st = new Stack<>();
        for (char x : str.toCharArray())
            if (Character.isDigit(x)) {
                st.push(x - '0');
            } else {
                int rt = st.pop();
                int lt = st.pop();
                if (x == '+') st.push(lt + rt);
                if (x == '-') st.push(lt - rt);
                if (x == '*') st.push(lt * rt);
                if (x == '/') st.push(lt / rt);
            }
        return st.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
