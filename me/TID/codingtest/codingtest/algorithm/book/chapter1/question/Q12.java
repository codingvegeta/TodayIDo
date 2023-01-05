package algorithm.book.chapter1.question;

public class Q12 {
    public static void main(String[] args) {
        System.out.println("   |  1  2  3  4  5  6  7  8  9");
        System.out.println("---+---------------------------");
        for (int i = 1; i < 10; i++) {
            System.out.print(i);
            System.out.print("  |");
            for (int j = 1; j < 10; j++) {
                System.out.printf("%3d", i+j);
            }
            System.out.println();
        }
    }
}
