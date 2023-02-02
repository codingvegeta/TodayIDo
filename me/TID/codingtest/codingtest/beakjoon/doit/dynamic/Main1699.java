package beakjoon.doit.dynamic;

import java.io.*;

public class Main1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = i;
            for (int j = 1; j*j <= i ; j++) {
                if (d[i] > d[i - j * j] + 1) {
                    d[i] = d[i - j * j] + 1;
                }
            }
        }
        bw.write(d[n] + "\n");
        bw.close();

    }
}
