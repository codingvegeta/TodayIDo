package beakjoon.eight;

import java.util.Scanner;

public class Main2720
{
    public static void main(String[] args)
    {
        int[] d = {25,10,5,1};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            int money = sc.nextInt();
            for (int j = 0; j < d.length; j++)
            {
                System.out.print(money / d[j] + " ");
                money %= d[j];
            }
            System.out.println();
        }
    }
}
