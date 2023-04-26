package infrun.dbfs;

import java.util.*;

public class Dfss4 {
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;

    static void dfs(int l, int sum, Integer d[]) {
        if (answer <= l) {
            return;
        }
        if (sum > m) {
            return;
        }
        if (sum == m) {
            answer = Math.min(answer, l);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(l + 1, sum + d[i], d);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] d = new Integer[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        Arrays.sort(d, Collections.reverseOrder());
        m = sc.nextInt();
        dfs(0, 0, d);
        System.out.println(answer);
    }
}
