package beakjoon.doit.brute.permutation;

import java.io.*;
import java.util.StringTokenizer;

public class Main10971 {
    static boolean next(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[j] <= a[i - 1]) {
            j -= 1;
        }

        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = i;
        }
        int answer = Integer.MAX_VALUE;

        do {
            boolean ok = true;
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                if (a[d[i]][d[i + 1]] == 0) {
                    ok = false;
                } else {
                    sum += a[d[i]][d[i + 1]];
                }
            }
            if (ok && a[d[n - 1]][d[0]] != 0) {
                sum += a[d[n - 1]][d[0]];
                if (answer > sum) {
                    answer = sum;
                }
            }
        } while (next(d));
        bw.write(answer + "\n");
        bw.close();
    }
}
