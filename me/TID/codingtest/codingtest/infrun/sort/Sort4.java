package infrun.sort;

import java.util.Scanner;

public class Sort4 {
    static int[] solution(int n, int[] d) {
        int[] answer = new int[n];
        for (int x : d) {
            int pos = -1;
            for (int i = 0; i < n; i++) if (x == answer[i]) pos = i;
            if (pos == -1) {
                for (int i = n - 1; i >= 1; i--) {
                    answer[i] = answer[i - 1];
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    answer[i] = answer[i - 1];
                }
            }
            answer[0] = x;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] d = new int[m];
        for (int i = 0; i < m; i++) {
            d[i] = sc.nextInt();
        }
        for (int x : solution(n, d)) {
            System.out.print(x + " ");
        }
    }
}
