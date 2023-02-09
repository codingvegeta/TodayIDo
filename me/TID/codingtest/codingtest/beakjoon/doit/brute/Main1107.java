package beakjoon.doit.brute;

import java.io.*;
import java.util.StringTokenizer;

public class Main1107 {
    static boolean[] broken = new boolean[10];
    static int button(int n) {
        if (n == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int answer = 0;
        while (n > 0) {
            if (broken[n % 10]) {
                return 0;
            }
            answer += 1;
            n /= 10;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            broken[x] = true;
        }

        int answer = n - 100;
        if (answer < 0) {
            answer = -answer;
        }

        for (int i = 0; i <= 1000000; i++) {
            int c = i;
            int len = button(c);
            if (len > 0) {
                int press = c - n;
                if (press < 0) {
                    press = -press;
                }
                if (answer > len + press) {
                    answer = len + press;
                }
            }
        }
        bw.write(answer + "\n");
        bw.close();
    }
}
