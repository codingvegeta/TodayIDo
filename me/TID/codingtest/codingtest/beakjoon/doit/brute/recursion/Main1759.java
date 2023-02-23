package beakjoon.doit.brute.recursion;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759 {
    static StringBuilder sb = new StringBuilder();

    static boolean check(String password) {
        int ja = 0;
        int mo = 0;
        for (char x : password.toCharArray()) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo += 1;
            } else {
                ja += 1;
            }
        }
        return ja >= 2 && mo >= 1;
    }

    static void go(int n, String[] alpha, String password, int i) {
        if (password.length() == n) {
            if (check(password)) {
                sb.append(password);
                sb.append("\n");
            }
            return;
        }
        if (i>= alpha.length)return;
        go(n, alpha, password+alpha[i], i + 1);
        go(n, alpha, password, i + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[] alpha = br.readLine().split(" ");
        Arrays.sort(alpha);

        go(l, alpha, "", 0);
        bw.write(sb.toString());
        bw.close();
    }
}
