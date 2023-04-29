package programmers.level0;
// 문자열 돌리기

import java.util.Scanner;

public class Test56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for (char x : a.toCharArray()) {
            System.out.println(x);
        }
    }
}
