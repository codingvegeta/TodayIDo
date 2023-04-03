package infrun.string;

import java.util.Scanner;

public class String11 {
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        int duplicated = 0;
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                if (duplicated > 0) {
                    sb.append(duplicated + 1);
                }
                sb.append(str.charAt(i));
                duplicated = 0;
            } else {
                duplicated++;
            }
        }
        if (duplicated > 0) {
            sb.append(duplicated + 1);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        System.out.println(solution(input1));
    }
}
