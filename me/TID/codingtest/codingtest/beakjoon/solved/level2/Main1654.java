package beakjoon.solved.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] lan = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lan[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(lan);
        int min = lan[0];
        while (true) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += (lan[i] / min);
            }
            if (count < k) {
                min--;
            }
            if (count == k) {
                break;
            }
        }
        System.out.println(min);
    }
}
