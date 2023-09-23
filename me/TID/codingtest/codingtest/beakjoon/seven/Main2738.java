package beakjoon.seven;

import java.util.Scanner;

public class Main2738
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[][] d = new int[n][t];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < t; j++)
            {
                d[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < t; j++)
            {
                d[i][j] += sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < t; j++)
            {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
    }
}