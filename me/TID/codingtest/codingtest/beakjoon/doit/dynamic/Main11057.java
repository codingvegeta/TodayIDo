package beakjoon.doit.dynamic;

import java.io.*;

public class Main11057 {
    static final int mod = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[][] d = new long[n + 1][10];
        for (int i = 0; i <= 9; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    d[i][j] += d[i - 1][k] % mod;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += d[n][i];
        }
        bw.write(answer % mod + "\n");
        bw.close();
    }
}
