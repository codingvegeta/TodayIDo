package beakjoon.doit.brute;

import java.io.*;
import java.util.StringTokenizer;

public class Main1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int e = 1, s = 1, w = 1;
        for (int i = 1; true; i++) {
            if (e == E && s == S && w == W) {
                bw.write(i + "\n");
                break;
            }
            e += 1;
            s += 1;
            w += 1;
            if (e == 16) {
                e = 1;
            }
            if (s == 29) {
                s = 1;
            }
            if (w == 20) {
                w = 1;
            }
        }
        bw.close();
    }
}
