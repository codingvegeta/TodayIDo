package infrun.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class String3 {
    public static String solution(String str) {
        StringTokenizer st = new StringTokenizer(str);
        String answer = st.nextToken();
        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            if (answer.length() < next.length()) {
                answer = next;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();
        System.out.println(solution(input1));
        return;
    }
}
