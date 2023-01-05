package algorithm.book.chapter1.question;

public class Q16 {
    static void npira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n-i; j >0 ; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j < 2 * i; j++) {
                System.out.print( i % 10);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        npira(20);
//        System.out.println((1 % 10));
    }
}
