package infrun.recursive_tree_graph;

public class Dfs1 {
    static void dfs(int n) {
        if (n == 0) {
            return;
        } else {
            dfs(n - 1);
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        dfs(3);
    }
}
