package beakjoon.solved.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] apate = new int[14 + 1][14 + 1];
            for (int i = 0; i < 15; i++) {
                apate[0][i] = i;
            }
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int l = 0; l <= j; l++) {
                        apate[i][j] += apate[i - 1][l];
                    }
                }
            }
            System.out.println(apate[k][n]);
        }
    }
}
