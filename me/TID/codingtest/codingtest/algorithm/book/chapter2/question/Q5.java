package algorithm.book.chapter2.question;

import java.util.Arrays;

public class Q5 {
    static void rcopy(int[] a, int[] b) {
        for (int i = 0, j = a.length-1; i < b.length; i++, j--) {
            a[i] = b[j];
        }
    }

    public static void main(String[] args) {
        int[] b = new int[10];
        int[] a = new int[b.length];

        for (int i = 0; i < b.length; i++) {
            b[i] = i;
        }
        rcopy(a, b);
        System.out.println(Arrays.toString(a));
    }
}
