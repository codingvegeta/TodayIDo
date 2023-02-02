package beakjoon.doit.dynamic;

import java.io.*;

public class Main1003 {
    static int len = 41;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[][] fibo = new int[2][len];

        fibo[0][0] = 1;
        fibo[1][1] = 1;
        for (int i = 2; i <len ; i++) {
            fibo[0][i] = fibo[0][i - 1] + fibo[0][i - 2];
            fibo[1][i] = fibo[1][i - 1] + fibo[1][i - 2];
        }
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(fibo[0][n] + " " + fibo[1][n] + "\n");
            bw.flush();
        }
        bw.close();
    }
}
