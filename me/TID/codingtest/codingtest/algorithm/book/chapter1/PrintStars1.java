package algorithm.book.chapter1;

import java.util.Scanner;

public class PrintStars1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, w;

        System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.");

        do {
            System.out.println("n값: ");
            n = sc.nextInt();
        } while (n <= 0);

        do {
            System.out.println("w값: ");
            w = sc.nextInt();
        } while (w <= 0 || w > n);

        for (int i = 0; i < n; i++) {
            System.out.print("*");
            if (i % w == w - 1) {
                System.out.println();
            }
        }
        if (n % w != 0) {
            System.out.println();
        }
    }
}
