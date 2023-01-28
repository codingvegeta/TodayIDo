package beakjoon.doit.dynamic;

import java.util.Scanner;

public class Main1463 {
    public static int[] d;
    private static int doOne(int n) {
        if (n == 1) {
            return 0;
        }
        if (d[n] > 0) {
            return d[n];
        }
        d[n] = doOne(n - 1) + 1;
        if (n % 2 == 0) {
            int tmp = doOne(n / 2) + 1;
            if (d[n] > tmp) {
                d[n] = tmp;
            }
        }
        if (n % 3 == 0) {
            int tmp = d[n / 3] + 1;
            if (d[n] > tmp) {
                d[n] = tmp;
            }
        }
        return d[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        System.out.println(doOne(n));
    }
}
