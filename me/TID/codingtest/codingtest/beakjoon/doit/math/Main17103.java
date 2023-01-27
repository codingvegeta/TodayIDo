package beakjoon.doit.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17103 {
    public static void main(String[] args) throws IOException {
        final int MAX = 1000000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] prime = new int[MAX];
        boolean[] isPrime = new boolean[MAX + 1];
        isPrime[0] = isPrime[1] = true;
        int count = 0;
        for (int i = 2; i <= MAX; i++) {
            if (!isPrime[i]) {
                prime[count++] = i;
                for (int j = i + i; j <= MAX; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            for (int p : prime) {
                if (n - p >= 2 && p <= n - p) {
                    if (!isPrime[n - p]) {
                        answer++;
                    }
                } else {
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
