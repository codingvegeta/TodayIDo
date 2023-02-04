package beakjoon.doit.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Main11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = d[i];
            for (int j = 1; j < i; j++) {
                if (d[i] > d[j] && a[i] < a[j] + d[i]) {
                    a[i] = a[j] + d[i];
                }
            }
        }

        long answer = 0;
        for (int i = 0; i <= n; i++) {
            if (answer < a[i]) {
                answer = a[i];
            }
        }

        bw.write(answer + "\n");
        bw.close();
    }
}
