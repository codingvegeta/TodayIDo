package infrun.recursive_tree_graph;

public class Dfs2 {
    static void dfs(int n) {
        if (n == 0) {
            return;
        }
        dfs(n / 2);
        System.out.print(n % 2);
    }
    public static void main(String[] args) {
        dfs(11);
    }
}
