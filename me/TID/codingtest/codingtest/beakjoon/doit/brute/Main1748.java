package beakjoon.doit.brute;
import java.io.*;

public class Main1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        for (int start = 1, len = 1; start <= n; start *= 10, len++) {
            int end = start * 10 - 1;
            if (end > n) {
                end = n;
            }
            answer += (long) (end - start + 1) * len;
        }
        bw.write(answer + "\n");
        bw.close();
    }
}
