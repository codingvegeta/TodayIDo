package algorithm.book.chapter1;

import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a);
        System.out.println(b);
        while (b <= a) {
            System.out.println("a보다 큰 값을 입력하세요!");
            b = sc.nextInt();
            System.out.println(b);
        }

        System.out.println("b - a는 " + (b - a) + " 입니다");
    }
}
