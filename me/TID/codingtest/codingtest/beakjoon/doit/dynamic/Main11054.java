package beakjoon.doit.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Main11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int[] d2 = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            d2[i] = 1;
            for (int j = i+1; j < n; j++) {
                if (a[i] > a[j] && d2[i] < d2[j] + 1) {
                    d2[i] = d2[j] + 1;
                }
            }
        }

        int answer = d[0] + d2[0] - 1;
        for (int i = 1; i < n; i++) {
            if (answer < d[i] + d2[i] - 1) {
                answer = d[i] + d2[i] - 1;
            }
        }

        bw.write(answer + "\n");
        bw.close();
    }
}
