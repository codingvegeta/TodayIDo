package beakjoon.doit.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1158My {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> nk = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            nk.offer(i + 1);
        }
        sb.append("<");
        for (int i = 1; nk.size() > 0; i++) {
            if (i % k == 0) {
                sb.append(nk.poll());
                if (nk.size() > 0) {
                    sb.append(", ");
                }
                continue;
            }
            int c = nk.peek();
            nk.poll();
            nk.offer(c);
        }
        sb.append(">");
        System.out.println(sb);
    }
}
