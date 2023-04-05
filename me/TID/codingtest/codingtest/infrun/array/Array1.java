package infrun.array;

import java.util.Scanner;

public class Array1 {
    public static String solution(int[] d) {
        StringBuilder sb = new StringBuilder();
        sb.append(d[0] + " ");
        for (int i = 1; i < d.length; i++) {
            if (d[i-1] < d[i]) {
                sb.append(d[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println(solution(d));
    }
}
