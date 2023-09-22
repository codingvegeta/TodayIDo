package beakjoon.seven;

import java.util.Scanner;

public class Main2566
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[][] d = new int[10][10];
        String answer = null;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < d.length; i++)
        {
            for (int j = 1; j < d.length; j++)
            {
                d[i][j] = sc.nextInt();
                if (d[i][j] > max)
                {
                    answer = i + " " + j;
                    max = d[i][j];
                }
            }
        }
        System.out.println(max);
        System.out.println(answer);
    }
}