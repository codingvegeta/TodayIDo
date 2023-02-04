package beakjoon.doit.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Main1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n + 1][3];
        int[][] a = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                d[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            a[i][0] = Math.min(a[i - 1][1], a[i - 1][2]) + d[i][0];
            a[i][1] = Math.min(a[i - 1][0], a[i - 1][2]) + d[i][1];
            a[i][2] = Math.min(a[i - 1][0], a[i - 1][1]) + d[i][2];
        }
        bw.write(Math.min(Math.min(a[n][0], a[n][1]), a[n][2])+"\n");
        bw.close();
    }
}
