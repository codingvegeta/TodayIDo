package beakjoon.doit.dynamic;

import java.util.Scanner;

public class Main2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = n / 5;
//        if (n >= 5) {
            while (count >= 0) {
                if (n - count * 5 == 0) {
                    System.out.println(count);
                    break;
                } else {
                    int m = n - count * 5;
                    if (m >= 0) {
                        if (m % 3 == 0) {
                            System.out.println(count + m / 3);
                            break;
                        } else {
                            count--;
                        }
                    }
                }
                if (count < 0) {
                    System.out.println(-1);
                }
            }
        }
    }
//}
