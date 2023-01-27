package beakjoon.doit.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1212 {
    public static void main(String[] args) throws IOException {
        String[] eight = {"000", "001", "010", "011", "100", "101", "110", "111"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        if (s.length() == 1 && s.charAt(0) == '0') {
            sb.append(0);
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            if (start == true && c < 4) {
                if (c == 0) {
                    continue;
                } else if (c == 1) {
                    sb.append(1);
                } else if (c == 2) {
                    sb.append(10);
                } else if (c == 3) {
                    sb.append(11);
                }
                start = false;
            } else {
                sb.append(eight[c]);
                start = false;
            }
        }
        System.out.println(sb);
    }
}
