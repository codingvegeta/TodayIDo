package algorithm.book.chapter1;

public class Q15 {
    static void triangleLU(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i ; j--) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
    static void triangleRU(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i ; j++) {
                System.out.print(' ');
            }
            for (int j = i; j < n; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    static void triangleRB(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n ; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        triangleLU(5);
//        triangleRU(5);
        triangleRB(5);
    }

}
