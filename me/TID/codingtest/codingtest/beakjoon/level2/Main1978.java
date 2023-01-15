package beakjoon.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> prime = new ArrayList();
        prime.add(2);
        prime.add(3);
        int count = 0;
        for (int i = 5; i <= 1000; i += 2) {
            boolean flag = false;
            for (int j = 1; prime.get(j) * prime.get(j) <= i; j++) {
                if (i % prime.get(j) == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                prime.add(i);
            }
        }
        System.out.println(prime);
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            int number = Integer.parseInt(st.nextToken());
            if (number == 2 || number == 3) {
                count++;
            }
            for (int j = 0; prime.get(j) < number; j++) {
                if (number == 0 || number == 1) {
                    flag = true;
                }
                if (number % prime.get(j) == 0) {
                    flag = true;
                }
            }
            if (!flag) {
                count++;
            }
        }
        System.out.println(count);
    }
}
