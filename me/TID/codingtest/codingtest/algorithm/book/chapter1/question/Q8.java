package algorithm.book.chapter1.question;

public class Q8 {
    public static final int ONE = 1;
    public static final int HALF = 2;
    public static int gausSum2(int a, int b) {
        return (a + b) * (Math.abs(a - b) + ONE) / HALF;
    }

    public static void main(String[] args) {
        System.out.println("gausSum2(3,5) = " + gausSum2(3, 5));
        System.out.println(Math.abs(3 - 5));
        System.out.println("gausSum2(6,4) = " + gausSum2(6, 4));
    }
}
