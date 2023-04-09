package infrun.twopointer;

import java.util.Scanner;

public class Tp3 {
    static int solution(int n, int m, int[] d) {
        int answer = 0;
        int start = 0;
        int end = m;
        int max = 0;
        for (int i = 0; i < m; i++) {
            max += d[i];
        }
        while (end < n) {
            if (answer < max) {
                answer = max;
            }
            max -= d[start++];
            max += d[end++];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, d));
    }
}
