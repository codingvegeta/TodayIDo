package beakjoon.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이 문제 틀렸음 왜 틀렸나
public class Main1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[k+ 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= k; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= k; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = n; i <= k; i++) {
            if (!prime[i]) {
                System.out.println(i);
            }
        }
    }
}
