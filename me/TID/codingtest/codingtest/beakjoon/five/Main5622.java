package beakjoon.five;

import java.util.Scanner;

public class Main5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'A': case 'B': case 'C' :
                    n += 3;
                    break;
                case 'D': case 'E': case 'F' :
                    n += 4;
                    break;
                case 'G': case 'H':case 'I' :
                    n += 5;
                    break;
                case 'J': case 'K':case 'L' :
                    n += 6;
                    break;
                case 'M': case 'N':case 'O' :
                    n += 7;
                    break;
                case 'P': case 'Q': case 'R':case'S' :
                    n += 8;
                    break;
                case 'T': case 'U':case 'V' :
                    n += 9;
                    break;
                default:
                    n += 10;
            }
        }
        System.out.println(n);
    }
}
