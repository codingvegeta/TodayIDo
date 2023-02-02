package beakjoon.doit.dynamic;

import java.io.*;

public class Main10844 {
    static final int mod = 1000000000;
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        d = new int[n+1][10];

        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j - 1 >= 0) {
                    d[i][j] += d[i - 1][j - 1];
                }
                if (j + 1 <= 9) {
                    d[i][j] += d[i - 1][j + 1];
                }
                d[i][j] %= mod;
            }
        }

        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += d[n][i];
        }
        answer %= mod;
        bw.write(answer+"\n");
        bw.close();
    }
}
