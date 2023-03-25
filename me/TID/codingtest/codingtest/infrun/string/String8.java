package infrun.string;

import java.util.Scanner;

public class String8 {
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.reverse());
        sb.reverse();
        if (sb.toString().equals(sb2.toString())) {
            return "YES";
        }
        return "NO";
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();
        System.out.println(solution(input1.toLowerCase()));
    }
}
