package beakjoon.doit.brute;

import java.io.*;
import java.util.Arrays;

public class Main2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 9;
        int[] d = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(br.readLine());
            sum += d[i];
        }
        Arrays.sort(d);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sum - d[i] - d[j] == 100) {
                    for (int k = 0; k < n; k++) {
                        d[i] = 0;
                        d[j] = 0;
                        if (d[k] != 0) {
                            bw.write(d[k] + "\n");
                        }
                    }
                    bw.close();
                    return;
                }
            }
        }
    }
}
