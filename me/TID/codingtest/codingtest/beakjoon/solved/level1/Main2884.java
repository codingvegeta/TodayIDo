package beakjoon.solved.level1;

import java.util.Scanner;

public class Main2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] clock = str.split(" ");
        int hour = Integer.parseInt(clock[0]);
        int minute = Integer.parseInt(clock[1]);
        if (hour == 0 && minute < 45) {

            hour = 24;
        }
        int alarm = hour * 60 + minute - 45;
        int alarmMinute = alarm % 60;
        int alarmHour = (alarm - alarmMinute) / 60;
        System.out.printf("%d %d",alarmHour,alarmMinute);
    }
}
