package beakjoon.dd;
import java.io.*;

public class Main1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        if (n < 10) {
            n *= 10;
        }
        int d = n;
        while (true) {
            int a = d / 10;
            int b = d % 10;
            int c = a + b;
            if (c >= 10) {
                c %= 10;
            }
            d = b * 10 + c;
            count++;
            if (d == n) {
                break;
            }
        }
        bw.write(count + "\n");
        bw.close();
    }
}
