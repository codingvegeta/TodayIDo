package beakjoon.doit.dynamic;

import java.io.*;
public class Main2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n + 1];
        d[0] = 1;
        for (int i = 2; i <=n ; i++) {
            d[i] = d[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                d[i] += d[j] * 2;
            }
        }
        bw.write(d[n] + "\n");
        bw.close();
    }
}
