package infrun.recursive_tree_graph;

import java.util.Scanner;

public class Dfs7 {
    static int n,m, answer = 0;
    static int[] ch;
    static int[][] d;
    static void dfs(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (d[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    dfs(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();
        d = new int[n + 1][n + 1];
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            d[sc.nextInt()][sc.nextInt()] = 1;
        }
        ch[1] = 1;
        dfs(1);
        System.out.println(answer);
    }
}
