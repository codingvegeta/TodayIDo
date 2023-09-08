package beakjoon.six;

import java.util.Scanner;

public class Main10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int answer = 1;
        for (int i = 0; i < str.length() / 2; i++) {
            boolean isPalindrome = str.charAt(i) == str.charAt(str.length() - i - 1);
            if (!isPalindrome) {
                System.out.println(0);
                return;
            }

        }
        System.out.println(answer);

    }
}
