package infrun.sort;

import java.util.Scanner;

public class Sort2 {
    static int[] solution(int n, int[] d) {
        for (int i = d.length - 1; i > 0; i--) {
            for (int j = 0; j < i ; j++) {
                if (d[j] > d[j + 1]) {
                    int tmp = d[j];
                    d[j] = d[j + 1];
                    d[j + 1] = tmp;
                }
            }
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
        for(int x : solution(n,d)){
            System.out.print(x + " ");
        }
    }
}
