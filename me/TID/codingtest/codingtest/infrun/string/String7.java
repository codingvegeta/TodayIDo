package infrun.string;

import java.util.Scanner;

public class String7 {
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).reverse();
        if (str.equals(sb.toString())) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        System.out.println(solution(input1.toLowerCase()));
    }
}
