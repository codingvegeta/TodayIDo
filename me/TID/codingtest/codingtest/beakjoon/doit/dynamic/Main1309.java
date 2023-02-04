package beakjoon.doit.dynamic;

import java.io.*;

public class Main1309 {
    static int mod = 9901;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] d = new long[n + 1][3];
        d[0][0] = 1;
        long[] a = new long[n + 1];
        a[0] = 1;
        for (int i = 1; i <= n; i++) {
            d[i][0] = (d[i - 1][0] + d[i - 1][1] + d[i - 1][2]) % mod;
            d[i][1] = (d[i - 1][0] + d[i - 1][2]) % mod;
            d[i][2] = (d[i - 1][0] + d[i - 1][1]) % mod;
            a[i] = (d[i][0]  + d[i][1] + d[i][2] ) % mod;
        }
        bw.write(a[n] + "\n");
        bw.close();
    }
}
