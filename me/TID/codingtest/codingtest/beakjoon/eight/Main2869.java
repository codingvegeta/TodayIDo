package beakjoon.eight;

import java.util.Scanner;

public class Main2869
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int speed = sc.nextInt();
        int down = sc.nextInt();
        int height = sc.nextInt();
        int answer = 1;
        answer += (height - speed) / (speed - down);
        if ((height - speed) % (speed - down) > 0)
        {
            answer++;
        }
        System.out.println(answer);
    }
}
