package beakjoon.level1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList list = new ArrayList<>();
        ArrayList alphaList = new ArrayList();
        for (char i ='a' ; i <= 'z'; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            alphaList.add(-1);
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (str.charAt(i) == (char) list.get(j)) {
                    alphaList.set(j, str.indexOf(str.charAt(i)));
                }
            }
        }
        for (int i = 0; i < alphaList.size(); i++) {
            System.out.print(alphaList.get(i));
            System.out.print(" ");
        }
    }
}
