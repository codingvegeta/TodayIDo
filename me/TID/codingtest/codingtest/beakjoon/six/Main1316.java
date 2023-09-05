package beakjoon.six;

import java.util.Scanner;

public class Main1316
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = n;
        for (int i = 0; i < n; i++)
        {
            String str = sc.next();
            boolean gap = true;
            for (int j = 0; j < str.length(); j++)
            {
                char c = str.charAt(j);
                boolean flag = false;
                for (int k = j+1; k < str.length(); k++)
                {
                    if (c != str.charAt(k))
                    {
                        flag = true;
                    }
                    if (flag && c == str.charAt(k))
                    {
                        gap = false;
                    }
                }
            }
            if (!gap)
            {
                answer--;
            }
        }
        System.out.println(answer);
    }
}
