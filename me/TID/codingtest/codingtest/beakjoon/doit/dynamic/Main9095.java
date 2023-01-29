package beakjoon.doit.dynamic;

import java.util.Scanner;

public class Main9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[12];
        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i < d.length; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }

        while (n-- > 0) {
            int k = sc.nextInt();
            System.out.println(d[k]);
        }
    }
}
