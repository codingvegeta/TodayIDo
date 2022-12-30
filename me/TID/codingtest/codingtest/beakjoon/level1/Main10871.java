package beakjoon.level1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        ArrayList list = new ArrayList();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        for (int i = 0; i < list.size(); i++) {
            if ((int) list.get(i) >= X) {
                list.set(i, 0);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if ((int) list.get(i) != 0) {
                System.out.print(list.get(i));
                System.out.print(" ");
            }
        }
    }
}
