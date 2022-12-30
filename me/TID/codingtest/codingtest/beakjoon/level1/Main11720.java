package beakjoon.level1;

import java.util.Scanner;

public class Main11720 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            sum += (str.charAt(i) - '0');
        }
        System.out.println(sum);

    }
}
