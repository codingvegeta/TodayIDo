package beakjoon.level1;

import java.util.Arrays;
import java.util.Scanner;

public class Main2920 {
    public static void main(String[] args) {
        int[] ascending = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] descending = {8, 7, 6, 5, 4, 3, 2, 1};
        Scanner sc = new Scanner(System.in);
        int[] um = new int[8];
        for (int i = 0; i < 8; i++) {
            um[i] = sc.nextInt();
        }

        if (Arrays.equals(um, ascending)) {
            System.out.println("ascending");
        } else if (Arrays.equals(um, descending)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
