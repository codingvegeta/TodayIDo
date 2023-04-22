package infrun.sort;

import java.util.Scanner;

public class Sort3 {
    static int[] solution(int[] d) {
        for (int i = 1; i < d.length; i++) {
            int tmp = d[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (d[j] > tmp) {
                    d[j + 1] = d[j];
                } else break;
            }
            d[j + 1] = tmp;
        }
        return d;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        for(int x : solution(d)){
            System.out.print(x + " ");
        }
    }
}
