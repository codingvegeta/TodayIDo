package infrun.stack_que;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sq6 {
    static int solution(int n, int m) {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            que.offer(i);
        }
        int count = 0;
        while (que.size() > 1) {
            count++;
            Integer poll = que.poll();
            if (count % m != 0) {
                que.offer(poll);
            }
        }
        return que.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(solution(n, m));
    }
}
