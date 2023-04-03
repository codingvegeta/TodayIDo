package infrun.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class String12 {
    public static String solution(int n , String str) {
        String replace = str.replace('#', '1');
        String replace1 = replace.replace('*', '0');
        StringBuilder sb = new StringBuilder();
        String[] answer = new String[n];
        int start = 0;
        int end = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = replace1.substring(start, 7 * end);
            start = 7 * end;
            end++;
        }
        for (int i = 0; i < answer.length; i++) {
            sb.append((char)Integer.parseInt(answer[i],2));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();
        String input2 = in.next();
        System.out.println(solution(input1, input2));
    }
}
