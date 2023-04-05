package infrun.array;

import java.util.Scanner;

public class Array4 {
    static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] d = new int[n];
        d[0] = d[1] = 1;
        for (int i = 2; i < n; i++) {
            d[i] = d[i - 2] + d[i - 1];
        }
        for (int i = 0; i < n; i++) {
            sb.append(d[i] + " ");
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
