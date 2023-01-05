package algorithm.book.chapter1.question;

public class Q3 {
    public static int min4(int a, int b, int c, int d) {
        int min = a;
        if (min > b) min = b;
        if (min > c) min = c;
        if (min > d) min = d;
        return min;
    }

}
