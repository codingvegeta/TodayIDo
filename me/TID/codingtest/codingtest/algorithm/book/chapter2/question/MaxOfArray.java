package algorithm.book.chapter2.question;

import java.util.Scanner;

public class MaxOfArray {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("키의 최댓값을 구하기");

        System.out.print("사람 수:");
        int num = sc.nextInt();

        int[] height = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.println("height[" + i + "]:");
            height[i] = sc.nextInt();
        }

        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }
}
