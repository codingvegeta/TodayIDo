package beakjoon.dd;

import java.util.Scanner;

public class Main11382 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        System.out.println(Long.parseLong(split[0]) + Long.parseLong(split[1]) + Long.parseLong(split[2]));
    }
}
