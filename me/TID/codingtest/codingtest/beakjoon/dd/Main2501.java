package beakjoon.dd;

import java.io.*;
import java.util.StringTokenizer;

public class Main2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                k--;
            }

            if (k == 0) {
                answer = i;
                break;
            }
        }
        bw.write(answer + "\n");
        bw.close();
    }
}
