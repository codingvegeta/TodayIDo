package infrun.dbfs;

import java.util.Scanner;

public class Dfss3 {
    static int n ;
    static int t;
    static int[] time;
    static int answer = Integer.MIN_VALUE;

    static void dfs(int l, int times, int sum, int[] d) {
        if (times > t) {
            return;
        }
        if (l == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(l + 1, times + time[l], sum + d[l], d);
            dfs(l + 1, times, sum, d);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        int[] d = new int[n];
        time = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        dfs(0, 0, 0, d);
        System.out.println(answer);
    }
}
