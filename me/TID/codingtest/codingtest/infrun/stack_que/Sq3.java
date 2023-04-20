package infrun.stack_que;

import java.util.Scanner;
import java.util.Stack;

public class Sq3 {
    static int solution(int[][] d, int[] t) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for (int pos : t) {
            for (int i = 0; i < d.length; i++) {
                if (d[i][pos - 1] != 0) {
                    int pick = d[i][pos - 1];
                    d[i][pos - 1] = 0;
                    if (!st.isEmpty() && st.peek() == pick) {
                        answer += 2;
                        st.pop();
                    } else {
                        st.push(pick);
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] =sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] t = new int[m];
        for (int i = 0; i < m; i++) {
            t[i] = sc.nextInt();
        }
        System.out.println(solution( d, t));
    }
}
