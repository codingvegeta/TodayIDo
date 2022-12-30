package algorithm.book.chapter1;

import java.util.Scanner;

public class Alternative1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("+ 와 - 를 번갈아 " + n / 2 + "개 출력합니다.");

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.print("+");
            }else
                System.out.print("-");
        }
    }
}
