package algorithm.book.chapter2.question;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("10진수를 기수 변환 합니다.");
        System.out.print("변환하는 음이 아닌 정수: ");
        int n = 59;
        System.out.println();
        System.out.print("어떤 진수로 변환할까요? (2~36) :");
        System.out.println();
        int b = 2;
        char[] cno = new char[32];
        int dno = CardConv.cardConv(n, b, cno);
        System.out.print(b+"진수로");
        for (int i = 0; i < dno; i++) {
            System.out.print(cno[i]);
        }
        System.out.println("입니다.");
    }
}
