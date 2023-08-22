package beakjoon.four;

import java.util.Scanner;

public class Main5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] d = new boolean[31];
        for (int i = 1; i <= 28; i++) {
            d[sc.nextInt()] = true;
        }
        int a = 0;
        int b = 0;
        for (int i = 1; i < d.length; i++) {
            if (!d[i]) {
                if (a == 0) {
                    a = i;
                } else {
                    b = i;
                }
            }
        }
        System.out.println(Math.min(a, b));
        System.out.println(Math.max(a, b));
    }
}
