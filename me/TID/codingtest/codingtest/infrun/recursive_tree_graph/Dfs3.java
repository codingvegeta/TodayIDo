package infrun.recursive_tree_graph;

public class Dfs3 {
    static int dfs(int n) {
        if (n == 1) {
            return 1;
        }
        return n * dfs(n - 1);
    }
    public static void main(String[] args) {
        System.out.println(dfs(5));
    }
}
