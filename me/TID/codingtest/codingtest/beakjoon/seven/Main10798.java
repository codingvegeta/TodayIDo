package beakjoon.seven;

import java.util.Scanner;

public class Main10798
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[][] d = new String[15][15];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 5; i++)
        {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++)
            {
                d[i][j] = String.valueOf(str.charAt(j));
            }
        }
        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (d[j][i] != null)
                {
                    sb.append(d[j][i]);
                }
            }
        }
        System.out.println(sb.toString());
    }
}