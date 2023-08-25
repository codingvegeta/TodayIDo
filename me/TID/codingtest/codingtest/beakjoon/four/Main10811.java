package beakjoon.four;

import java.io.*;
import java.util.StringTokenizer;

public class Main10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] d = new int[n + 1];
        for (int i = 1; i < d.length; i++) {
            d[i] = i;
        }

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmp = 0;
            int count = 0;
            for (int j = a; j <= b; j++) {
                int m = b--;

                tmp = d[j];
                d[j] = d[m];
                d[m] = tmp;
            }
        }
        for (int i = 1; i < d.length; i++) {
            bw.write(d[i] + " ");
        }
        bw.close();
    }
}
