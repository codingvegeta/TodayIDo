package beakjoon.doit.brute.nm;

import java.io.*;
import java.util.StringTokenizer;

public class Main15652 {
    static int[] a = new int[10];
    static StringBuilder sb = new StringBuilder();

    static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i]);
                if (i != m - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            a[index] = i;
            go(index + 1, i, n, m);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        go(0, 1, n, m);
        bw.write(sb.toString());
        bw.close();
    }
}
