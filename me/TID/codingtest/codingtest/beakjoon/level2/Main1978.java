package beakjoon.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] prime = new boolean[1001];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        int count = 0;
        for (int i = 2; i <= Math.sqrt(1000); i++) {
            int j = 2;
            while (i * j <= 1000) {
                prime[i * j] = false;
                j++;
            }

        }

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (prime[number] == true) {
                count++;
            }
        }
        System.out.println(count);
    }
}
