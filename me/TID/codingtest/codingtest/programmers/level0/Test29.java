package programmers.level0;

import java.util.Scanner;

// 홀짝 구분하기
public class Test29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n%2==0){
            System.out.println(n+" is even");
        }else{
            System.out.println(n+" is odd");
        }
    }
}
