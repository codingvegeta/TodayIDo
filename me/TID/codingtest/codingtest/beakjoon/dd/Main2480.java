package beakjoon.dd;

import java.util.Scanner;

public class Main2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int one = sc.nextInt();
        int two = sc.nextInt();
        int three = sc.nextInt();

        if (one == two && one == three) {
            System.out.println(10000 + one * 1000);
        } else if (one != two && one != three && two != three) {
            int max1 = Math.max(one, two);
            int max2 = Math.max(max1, three);
            System.out.println(max2 * 100);
        } else {
            if (one == two) {
                System.out.println(1000 + one * 100);
            } else if (one == three) {
                System.out.println(1000 + one * 100);
            } else {
                System.out.println(1000 + two * 100);
            }
        }
    }
}
