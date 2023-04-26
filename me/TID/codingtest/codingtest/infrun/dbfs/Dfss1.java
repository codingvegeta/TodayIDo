package infrun.dbfs;

import java.util.Scanner;

public class Dfss1 {
    static String answer = "NO";
    static int n, total = 0;
    static boolean flag = false;

    static void dfs(int l, int sum, int[] d) {
        if (flag) return;
        if (sum > total / 2) return;
        if (l == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(l + 1, sum + d[l], d);
            dfs(l + 1, sum, d);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
            total += d[i];
        }
        dfs(0, 0, d);
        System.out.println(answer);
    }
}
