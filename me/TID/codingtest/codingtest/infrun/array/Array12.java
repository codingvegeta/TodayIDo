package infrun.array;

import java.util.Scanner;

public class Array12 {
    static int solution(int n, int m, int[][] d) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int count = 0;
                for (int k = 0; k <m; k++) {
                    int pi = 0, pj = 0;
                    for (int l = 0; l < n; l++) {
                        if (d[k][l] == i) {
                            pi = l;
                        }
                        if (d[k][l] == j) {
                            pj = l;
                        }
                    }
                    if (pi > pj) {
                        count++;
                    }
                }
                if (count == m) {
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
        int[][] d = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, m, d));
    }
}
