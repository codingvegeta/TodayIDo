package beakjoon.six;

import java.util.Scanner;

public class Main2941
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String replaced = str.replaceAll("c=", "A").replaceAll("c-", "A").replaceAll("dz=", "A")
                .replaceAll("d-", "A").replaceAll("lj", "A").replaceAll("nj", "A")
                .replaceAll("s=", "A").replaceAll("z=", "A");
        /*
        c= c- dz= d- lj nj s= z=
         */
        System.out.println(replaced.length());
    }
}
