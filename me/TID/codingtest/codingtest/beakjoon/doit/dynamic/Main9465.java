package beakjoon.doit.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Main9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] d = new int[n + 1][2];
            int[][] a = new int[n + 1][3];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                    d[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                d[i][1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                a[i][0] = Math.max(a[i - 1][0], Math.max(a[i - 1][1], a[i - 1][2]));
                a[i][1] = Math.max(a[i - 1][0], a[i - 1][2]) + d[i][0];
                a[i][2] = Math.max(a[i - 1][0], a[i - 1][1]) + d[i][1];
            }

            long answer = 0;
            answer = Math.max(a[n][0], Math.max(a[n][1], a[n][2]));
            bw.write(answer + "\n");
        }
        bw.close();
    }
}
