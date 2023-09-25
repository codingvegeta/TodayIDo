package beakjoon.solved.level1;

import java.util.Scanner;

public class Main10250
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int t = sc.nextInt();

            int X, Y;
            if(t % h == 0) {
                System.out.println((h * 100) + (t / h));
            } else {
                System.out.println(((t % h) * 100) + ((t / h) + 1));
            }
        }
    }
}
