package beakjoon.doit.dynamic;

import java.util.Scanner;

public class Main11726 {
    static int[] d;
    static int fill(int n) {
        if (n == 1) {
            return 1;
        }
        d[0] = d[1] = 1;
        for (int i = 2; i <= n; i++) {
        d[i] = d[i - 1] + d[i - 2];
            d[i] %= 10007;
        }
        return d[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1];
        System.out.println(fill(n));
    }
}
