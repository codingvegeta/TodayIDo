package infrun.string;

import java.util.Scanner;

public class String5 {
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        sb.reverse();

        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                answer.append(sb.charAt(j));
                j++;
            } else {
                answer.append(str.charAt(i));
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(solution(input));
    }
}
