package algorithm.book.chapter2.question;

import java.util.Arrays;

public class Q4 {
    static void copy(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
    }

    public static void main(String[] args) {
        int[] b = new int[10];
        int[] a = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = i;
        }
        copy(a, b);
        System.out.println(Arrays.toString(a));

    }
}
