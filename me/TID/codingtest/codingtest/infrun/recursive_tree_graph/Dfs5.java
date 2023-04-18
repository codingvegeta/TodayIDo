package infrun.recursive_tree_graph;
class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}
public class Dfs5 {
    Node root;

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        // 전위 -> 중앙 왼쪽 오른쪽
        dfs(root.lt);
        // 중위 -> 왼쪽 중앙 오른쪽
        dfs(root.rt);
        // 후위 -> 왼쪽 오른쪽 중앙
    }

    public static void main(String[] args) {
        Dfs5 tree = new Dfs5();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.dfs(tree.root);
    }
}
