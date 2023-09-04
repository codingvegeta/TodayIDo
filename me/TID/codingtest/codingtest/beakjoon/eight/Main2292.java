package beakjoon.eight;

import java.util.Scanner;

public class Main2292
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 1;
        while ( n > 1)
        {
            n = n - (6 * answer);
            answer++;
        }
        System.out.println(answer);
    }
}
