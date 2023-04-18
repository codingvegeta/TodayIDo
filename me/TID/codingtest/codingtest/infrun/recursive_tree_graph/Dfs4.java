package infrun.recursive_tree_graph;

public class Dfs4 {
    static int[] fibo;
    static int dfs(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1) {
            return fibo[n] = 1;
        }
        if (n == 2) {
            return fibo[n] = 1;
        }
        return fibo[n] = dfs(n - 2) + dfs(n - 1);
    }

    public static void main(String[] args) {
        int n = 45;
        fibo = new int[n + 1];
        dfs(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
