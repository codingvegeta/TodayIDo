package infrun.array;

import java.util.Scanner;

public class Array11 {
    static int solution(int n, int[][] d) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (d[i][k] == d[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if (max < count) {
                max = count;
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n + 1][6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                d[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, d));
    }
}
