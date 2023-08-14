package beakjoon.dd;

import java.util.Scanner;

public class Main2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int time = sc.nextInt();

        minute = time + minute;
        if (minute >= 60) {
            hour += (minute / 60);
            minute %= 60;
        }
        if (hour >= 24) {
            hour -= 24;
        }
        System.out.println(hour + " " + minute);
    }
}
