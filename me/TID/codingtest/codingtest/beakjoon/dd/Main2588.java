package beakjoon.dd;

import java.util.Scanner;

public class Main2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = new String[2];
        for (int i = 0; i < 2; i++) {
            strs[i] = sc.nextLine();
        }
        String[] splits = strs[1].split("");
        Long[] asd = new Long[3];
        asd[0] = Long.parseLong(splits[2]) * Long.parseLong(strs[0]);
        asd[1] = Long.parseLong(splits[1]) * Long.parseLong(strs[0]);
        asd[2] = Long.parseLong(splits[0]) * Long.parseLong(strs[0]);
        System.out.println(asd[0]);
        System.out.println(asd[1]);
        System.out.println(asd[2]);
        System.out.println(Long.parseLong(strs[0]) * Long.parseLong(strs[1]));
    }
}
