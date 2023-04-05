package infrun.array;

import java.util.Scanner;

public class Array6 {
    static String solution(String[] s) {
        StringBuilder sb = new StringBuilder();
        int[] d = new int[s.length];
        int max = 0;
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
            sb.reverse();
            d[i] = Integer.parseInt(sb.toString());
            if (max < d[i]) {
                max = d[i];
            }
            sb.delete(0, sb.length());
        }
        boolean[] b = new boolean[max + 1];
        b[0] = b[1] = true;
        for (int i = 2; i < max; i++) {
            for (int j = 2; i * j <= max; j++) {
                b[i * j] = true;
            }
        }
        for (int i = 0; i < d.length; i++) {
            if (!b[d[i]]) {
                sb.append(d[i] + " ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < s.length; i++) {
            s[i]= sc.next();
        }
        System.out.println(solution(s));
    }
}
