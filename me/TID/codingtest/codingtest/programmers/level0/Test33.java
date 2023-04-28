package programmers.level0;

import java.util.Scanner;

// 직각삼각형 출력하기
public class Test33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i<n; i++){
            for(int j =0; j<i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
