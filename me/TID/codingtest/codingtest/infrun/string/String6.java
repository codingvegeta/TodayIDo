package infrun.string;

import java.util.Scanner;

public class String6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(solution(input));
    }

    private static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c != ' ') {
            sb.append(str.charAt(i));
            str = str.replace(c, ' ');
            length = str.length();
            }
        }
        return sb.toString();
    }
}
