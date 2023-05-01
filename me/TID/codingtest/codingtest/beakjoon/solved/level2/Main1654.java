package beakjoon.solved.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] lan = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lan[i]);
        }

        long lt = 1;
        long rt = max;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += lan[i] / mid;
            }
            if (sum < k) {
                rt = mid -1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println((lt + rt) / 2);
    }
}
