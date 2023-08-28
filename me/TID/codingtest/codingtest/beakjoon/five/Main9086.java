package beakjoon.five;

import java.util.Scanner;

public class Main9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            System.out.println(str.charAt(0) + "" + str.charAt(str.length() - 1));
        }
    }
}
