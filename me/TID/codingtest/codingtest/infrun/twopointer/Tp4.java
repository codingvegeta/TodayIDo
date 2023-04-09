package infrun.twopointer;

import java.util.Scanner;

public class Tp4 {
    static int solution(int n, int m, int[] d) {
        int answer = 0;
        int lt = 0;
        int sum = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += d[rt];
            if (sum == m) {
                answer++;
            }
            while (sum >= m) {
                sum -= d[lt++];
                if (sum == m) {
                    answer++;
                }
            }
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
