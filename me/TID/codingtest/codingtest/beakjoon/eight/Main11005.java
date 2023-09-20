package beakjoon.eight;

import java.util.Scanner;

public class Main11005
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long t = sc.nextInt();
        String str = new String();
        StringBuffer sb = new StringBuffer();
        while (n !=0)
        {
            str = ""+n % t;
            if (t > 10)
            {
                str = str.replace("10", "A").replace("11", "B").replace("12", "C").replace("13", "D")
                        .replace("14", "E").replace("15", "F").replace("16", "G").replace("17", "H")
                        .replace("18", "I").replace("19", "J").replace("20", "K").replace("21", "L")
                        .replace("22", "M").replace("23", "N").replace("24", "O").replace("25", "P")
                        .replace("26", "Q")
                        .replace("27", "R").replace("28", "S").replace("29", "T").replace("30", "U")
                        .replace("31", "V").replace("32", "W").replace("33", "X").replace("34", "Y")
                        .replace("35", "Z");
            }
            n = n / t;
            sb.append(str);
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}
