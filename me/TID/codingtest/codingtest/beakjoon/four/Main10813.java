package beakjoon.four;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        Map map = new HashMap();
        for (int i = 1; i <= n; i++) {
            map.put(i, i);
        }
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int changeA = (int) map.get(a);
            int changeB = (int) map.get(b);
            map.put(a, changeB);
            map.put(b, changeA);
        }
        for (int i = 1; i <= n; i++) {
            bw.write(map.get(i) + " ");
        }
        bw.close();
    }
}
