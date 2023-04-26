package infrun.dbfs;

import java.util.Scanner;

public class Dfss5 {
    static int[][] dp;
    static int dfs(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            dp[n][r] = 1;
            return 1;
        } else {
            return dp[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        dp = new int[n + 1][r + 1];
        System.out.println(dfs(n, r));
    }
}
