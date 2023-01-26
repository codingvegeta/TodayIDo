package algorithm.book.chapter3;

import java.util.ArrayList;

public class Q2 {
    public static int scanning(int[] a, int n, int key) {
        System.out.print("   |");
        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %3d", i);
        }
        System.out.println();
        System.out.print("---+----------------\n");
        for (int i = 0; i < a.length; i++) {
            System.out.print("   |");
            System.out.printf(String.format("%%%ds*\n", (i * 3) + 4), "");
            System.out.printf("%3d", i);
            for (int k = 0; k < n; k++)
                System.out.printf("%4d", a[k]);
            System.out.println("\n   |");
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = {6, 4, 3, 2, 1, 9, 8};
        int n = 3;
        scanning(a, 7, 3);
    }
}
