package beakjoon.doit.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Main13398 {
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
        int[] dr = new int[n];
        for (int i=0; i<n; i++) {
            d[i] = a[i];
            if (i > 0 && d[i] < d[i-1] + a[i]) {
                d[i] = d[i-1] + a[i];
            }
        }
        for (int i=n-1; i>=0; i--) {
            dr[i] = a[i];
            if (i < n-1 && dr[i] < dr[i+1] + a[i]) {
                dr[i] = dr[i+1] + a[i];
            }
        }

        int answer = d[0];
        for (int i = 1; i < n; i++) {
            if (answer < d[i]) {
                answer = d[i];
            }
        }
        for (int i = 1; i < n-1; i++) {
            if (answer < d[i - 1] + dr[i + 1]) {
                answer = d[i - 1] + dr[i + 1];
            }
        }
        bw.write(answer + "\n");
        bw.close();
    }
}
