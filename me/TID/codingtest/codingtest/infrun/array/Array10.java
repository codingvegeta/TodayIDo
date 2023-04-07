package infrun.array;

import java.util.Scanner;

public class Array10 {
    static int solution(int[][] d) {
        int answer = 0;
        if (d[0][0] > d[0][1] && d[0][0] > d[1][0]) {
            answer++;
        }
        if (d[0][d.length - 1] > d[0][d.length - 2] && d[0][d.length - 1] > d[1][d.length - 1]) {
            answer++;
        }
        if (d[d.length - 1][0] > d[d.length - 2][0] && d[d.length - 1][0] > d[d.length - 1][1]) {
            answer++;
        }
        if (d[d.length - 1][d.length - 1] > d[d.length - 2][d.length - 1] && d[d.length - 1][d.length - 1] > d[d.length - 1][d.length - 2]) {
            answer++;
        }

        for (int i = 1; i < d.length - 1; i++) {
            if (d[0][i] > d[0][i - 1] && d[0][i] > d[0][i + 1] && d[0][i] > d[1][i]) {
                answer++;
            }
        }

        for (int i = 1; i < d.length - 1; i++) {
            if (d[i][0] > d[i - 1][0] && d[i][0] > d[i + 1][0] && d[i][0] > d[i][1]) {
                answer++;
            }
        }

        for (int i = 1; i < d.length - 1; i++) {
            if (d[i][d.length - 1] > d[i - 1][d.length - 1] && d[i][d.length - 1] > d[i][d.length - 2] && d[i][d.length - 1] > d[i + 1][d.length - 1]) {
                answer++;
            }
        }

        for (int i = 1; i < d.length - 1; i++) {
            if (d[d.length - 1][i] > d[d.length - 1][i - 1] && d[d.length - 1][i] > d[d.length - 2][i] && d[d.length - 1][i] > d[d.length - 1][i + 1]) {
                answer++;
            }
        }


        for (int i = 1; i < d.length - 1; i++) {
            for (int j = 1; j < d.length - 1; j++) {
                if (d[i][j] > d[i - 1][j] && d[i][j] > d[i][j - 1] && d[i][j] > d[i + 1][j] && d[i][j] > d[i][j + 1]) {
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(d));
    }
}
