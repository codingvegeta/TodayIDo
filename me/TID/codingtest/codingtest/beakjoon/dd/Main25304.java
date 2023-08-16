package beakjoon.dd;

import java.util.Scanner;

public class Main25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long answer = sc.nextLong();
        long n = sc.nextLong();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextLong() * sc.nextLong();
        }
        System.out.println(answer == sum ? "Yes" : "No");
    }
}
