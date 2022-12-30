package algorithm.book.chapter1;

public class Q4 {
    public static int middle(int a, int b, int c) {
        int middle = (a + b + c) - Q1.max3(a, b, c) - Q2.min3(a, b, c);

        if (middle == a) {
            return a;
        } else if (middle == b) {
            return b;
        } else return c;
    }
    public static int middle2(int a, int b, int c) {
        int middle = (Q1.max3(a, b, c) + Q2.min3(a, b, c) )/2;

        if (middle == a) {
            return a;
        } else if (middle == b) {
            return b;
        } else return c;
    }

    public static void main(String[] args) {
        System.out.println("middle(1, 4, 8) = " + middle(1, 4, 8));
        System.out.println("middle2(1, 4, 8) = " + middle2(1, 4, 8));
    }
}
