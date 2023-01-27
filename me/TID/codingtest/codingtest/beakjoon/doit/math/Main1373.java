package beakjoon.doit.math;

import java.util.Scanner;

public class Main1373 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        if (n%3 == 1) {
            System.out.print(str.charAt(0));
        } else if (n%3 == 2) {
            System.out.print((str.charAt(0)-'0')*2 + (str.charAt(1)-'0'));
        }
        for (int i=n%3; i<n; i+=3) {
            System.out.print((str.charAt(i)-'0')*4 + (str.charAt(i+1)-'0')*2 + (str.charAt(i+2)-'0'));
        }
        System.out.println();
    }
}
