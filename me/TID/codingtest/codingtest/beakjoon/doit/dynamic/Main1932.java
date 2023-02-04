package beakjoon.doit.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Main1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] d = new int[n + 1][n + 1];
        for (int i = 1; i <=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                d[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] a = new int[n + 1][n + 1];
        a[1][1] = d[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = Math.max(a[i - 1][j-1], a[i - 1][j]) + d[i][j];
            }
        }
        int answer = a[n][1];
        for (int i = 1; i <= n; i++) {
            if (answer < a[n][i]) {
                answer = a[n][i];
            }
        }

        bw.write(answer + "\n");
        bw.close();
    }
}
