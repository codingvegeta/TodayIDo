package beakjoon.solved.level1;

import java.util.Scanner;

public class Main2438 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int i = Integer.parseInt(str);
        for (int j = 0; j < i; j++) {
            for (int k = 0; k <= j; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
