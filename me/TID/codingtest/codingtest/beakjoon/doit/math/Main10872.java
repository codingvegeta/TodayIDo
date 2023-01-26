package beakjoon.doit.math;

import java.util.Scanner;

public class Main10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 1;
        for (int i = n; i > 0; i--) {
            sum *= i;
        }
        System.out.println(sum);
    }
}
