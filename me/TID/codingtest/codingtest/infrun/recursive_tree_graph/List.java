package infrun.recursive_tree_graph;

import java.util.ArrayList;
import java.util.Scanner;

public class List {
    static int n , m , answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    static void dfs(int v) {
        if (v == n) answer++;
        else {
            for (int nv : graph.get(v)) {
                if(ch[nv] == 0) {
                    ch[v] = 1;
                    dfs(nv);
                    ch[v] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            graph.get(sc.nextInt()).add(sc.nextInt());
        }
        ch[1] = 1;
        dfs(1);
        System.out.println(answer);
    }
}
