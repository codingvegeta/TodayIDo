package beakjoon.doit.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = n;
        while (n-- > 0) {
            int prime = Integer.parseInt(st.nextToken());
            if (prime == 1) {
                count--;
            }
            for (int i = 2; i * i <= prime; i++) {
                if (prime % i == 0) {
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
