package beakjoon.solved.level1;

import java.util.Scanner;

public class Main2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int sum = 0;

        String[] strList = str.split(" ");

        for (int i = 0; i <strList.length ; i++) {
            sum+= Integer.parseInt(strList[i])*Integer.parseInt(strList[i]);
        }
        int answer = sum % 10;

        System.out.println(answer);
    }
}
