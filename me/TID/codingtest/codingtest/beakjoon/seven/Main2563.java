package beakjoon.seven;

import java.util.Scanner;

public class Main2563
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[][] d = new int[100][100];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            int l = sc.nextInt();
            int r = sc.nextInt();
            for (int j = l; j < l + 10; j++)
            {
                for (int k = r; k < r + 10; k++)
                {
                    d[j][k] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < d.length; i++)
        {
            for (int j = 0; j < d.length; j++)
            {
                if (d[i][j] == 1)
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
