package beakjoon.doit.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i; j++) {
                if (d[i] < d[i - j] + a[j]) {
                    d[i] = d[i - j] + a[j];
                }
            }
        }
        System.out.println(d[n]);
    }
}
