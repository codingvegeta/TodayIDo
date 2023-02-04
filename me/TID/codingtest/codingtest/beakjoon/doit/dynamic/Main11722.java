package beakjoon.doit.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Main11722 {
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
        for (int i = 0; i <n ; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] < a[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (answer < d[i]) {
                answer = d[i];
            }
        }

        bw.write(answer + "\n");
        bw.close();
    }
}
