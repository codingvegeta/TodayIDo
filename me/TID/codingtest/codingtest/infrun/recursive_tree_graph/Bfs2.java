package infrun.recursive_tree_graph;

import java.util.*;

public class Bfs2 {
    static int[] jump = {1, -1, 5};
    static int solution(int n, int m) {
        int answer = 0;
        int[] d = new int[10001];
        Queue<Integer> q = new LinkedList();
        q.offer(n);
        d[n] = 1;
        int l = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                if (cur == m) {
                    return l;
                }
                d[cur] = 1;
                for (int j = 0; j < jump.length; j++) {
                    int next = cur + jump[j];
                    if (next >= 1 && next <= 10000 && d[next] == 0) {
                        d[next] = 1;
                        q.offer(next);
                    }
                }
            }
            l++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(solution(n, m));
    }
}
