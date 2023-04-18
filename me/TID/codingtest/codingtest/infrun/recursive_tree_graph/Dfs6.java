package infrun.recursive_tree_graph;
public class Dfs6 {

    static int n;
    static int[] ch;

    static void dfs(int l) {
        if (l == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
        ch[l] = 1;
        dfs(l + 1);
        ch[l] = 0;
        dfs(l + 1);
        }
    }

    public static void main(String[] args) {
        n = 3;
        ch = new int[n + 1];
        dfs(1);
    }
}
