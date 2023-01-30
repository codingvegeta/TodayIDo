package beakjoon.doit.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main15990 {
    static final long MAX = 1000000009;
    static final int limit = 100000;
    static long[][] d = new long[limit + 1][4];

    static long doit(int n) {
        if (n == 1) {
            return 1;
        }
        d[1][1] = 1;
        d[1][2] = d[1][3] = 0;
        d[2][1] = d[2][3] = 0;
        d[2][2] = 1;
        d[3][1] = d[3][2] = d[3][3] = 1;
        for (int i = 4; i <= n; i++) {
            d[i][1] = d[i - 1][2] + d[i - 1][3] % MAX;
            d[i][2] = d[i - 2][1] + d[i - 2][3] % MAX;
            d[i][3] = d[i - 3][1] + d[i - 3][2] % MAX;
        }

        return (d[n][1] + d[n][2] + d[n][3]) % MAX;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            System.out.println(doit(Integer.parseInt(br.readLine())));
        }
    }
}
