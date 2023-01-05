package algorithm.book.chapter1.question;

public class Q1 {
    public static int max3(int a, int b, int c) {
        int max = a;
        if (max < b) max = b;
        if (max < c) max = c;
        return max;
    }

    public static int max4(int a, int b, int c, int d) {
        int max = a;
        if (max < b) max = b;
        if (max < c) max = c;
        if (max < d) max = d;
        return max;
    }
}

