package infrun.dbfs;

import java.util.Scanner;

public class Dfss2 {
    static int answer = Integer.MIN_VALUE;
    static int n, m = 0;
    static void dfs(int l, int sum, int[] d) {
        if (sum > m) return;
        if (l == m) {
            answer = Math.max(answer, sum);
        } else {
            dfs(l + 1, sum + d[l], d);
            dfs(l + 1, sum, d);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] d = new int[m];
        for (int i = 0; i < m; i++) {
            d[i] = sc.nextInt();
        }
        dfs(0, 0, d);
        System.out.println(answer);
    }
}
