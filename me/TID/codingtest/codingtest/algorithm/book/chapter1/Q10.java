package algorithm.book.chapter1;

import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        while (n > 0) {
            n /= 10;
            sum++;
        }
        System.out.println("그 수는 " + sum + "자리입니다.");
    }
}
