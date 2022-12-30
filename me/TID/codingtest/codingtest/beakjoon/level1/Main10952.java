package beakjoon.level1;

import java.util.Scanner;

public class Main10952 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0) {
                break;
            }
            System.out.println(a + b);
        }
        sc.close();
    }
}
