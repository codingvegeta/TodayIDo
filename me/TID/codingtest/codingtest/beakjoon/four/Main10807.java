package beakjoon.four;

import java.io.*;
import java.util.StringTokenizer;

public class Main10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int count = 0;
        while (st.hasMoreTokens()) {
            if (t == Integer.parseInt(st.nextToken())) {
                count++;
            }
        }
        System.out.println(count);
    }
}
