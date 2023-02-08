package beakjoon.dd;
import java.io.*;
import java.util.StringTokenizer;

public class Main20053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (max < a) {
                    max = a;
                }
                if (min > a) {
                    min = a;
                }
            }
            bw.write(min + " " + max + "\n");
        }
        bw.close();
    }
}
