package algorithm.book.chapter1;

public class Q2 {
    public static int min3(int a, int b, int c) {
        int min = a;
        if (min > b) min = b;
        if (min > c) min = c;
        return min;
    }
}
