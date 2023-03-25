package infrun.string;

import java.util.Scanner;

public class String9 {
    public static int solution(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        System.out.println(solution(input1));
    }
}
