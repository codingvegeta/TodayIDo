package beakjoon.eight;

import java.util.Scanner;

public class Main2903
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tmp = 1;
        for (int i = 0; i < n; i++)
        {
            tmp *= 2;
        }
        System.out.println((tmp + 1) * (tmp + 1));
    }
}