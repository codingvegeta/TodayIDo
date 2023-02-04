package beakjoon.doit.dynamic;

import java.io.*;

public class Main15988 {
    static final int MAXIMUM = 1000000;
    static final int mod = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        long[] d = new long[MAXIMUM + 1];

        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= MAXIMUM; i++) {
            d[i] = (d[i - 1] + d[i - 2] + d[i - 3]) % mod;
        }
        while (t-- > 0) {
            bw.write(d[Integer.parseInt(br.readLine())] % mod + "\n");
        }

        bw.close();
    }
}
