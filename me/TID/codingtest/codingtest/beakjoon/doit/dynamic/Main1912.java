package beakjoon.doit.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Main1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[n];
        d[0] = a[0];
        for (int i = 1; i < n; i++) {
            d[i] = Math.max(a[i], d[i - 1] + a[i]);
        }
        int answer = Integer.MIN_VALUE;
        for (int i : d) {
            if (answer < i) {
                answer = i;
            }
        }
        bw.write(answer + "\n");
        bw.close();
    }
}
