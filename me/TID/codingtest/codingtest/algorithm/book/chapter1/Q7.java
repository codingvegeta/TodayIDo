package algorithm.book.chapter1;

public class Q7 {
    public static int gausSum(int n) {
        return (1 + n) * n / 2;
    }

    public static void main(String[] args) {
        System.out.println("gausSum(10) = " + gausSum(10));
        System.out.println("gausSum(5) = " + gausSum(5));
        System.out.println("gausSum(20) = " + gausSum(20));
        System.out.println("gausSum(4) = " + gausSum(4));
    }
}
