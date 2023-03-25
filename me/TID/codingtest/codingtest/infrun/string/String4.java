package infrun.string;

import java.util.Scanner;

public class String4 {
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String str = in.next();
            System.out.println(solution(str));
        }
    }
}
