package beakjoon.six;

import java.util.Scanner;

public class Main2444 {
    public static void main(String[] args) {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        for (int i = 1; i <= n * 2 - 1; i++) {
            if (!flag) {
                for (int j = i; j < n; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i * 2 - 1; j++) {
                    System.out.print("*");
                }
                if (i == n) {
                    flag = true;
                }
            } else {
                for (int j = 0; j < count; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < (n-count) * 2 -1; j++) {
                    System.out.print("*");
                }
                count++;
            }
            System.out.println();
        }
    }
}
