package level1;

import java.util.Scanner;

public class Main11654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char str1 = str.charAt(0);
        if ('a' <= str1 && str1 <= 'z') {
            System.out.println((int) str1);
        }
        if ('A' <= str1 && str1 <= 'Z') {
            System.out.println((int) str1);
        }
        if ('0' <= str1 && str1 <= '9') {
            System.out.println((int) str1);
        }
    }
}
