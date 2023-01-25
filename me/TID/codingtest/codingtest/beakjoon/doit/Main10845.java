package beakjoon.doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] que = new int[10000];
        int begin = 0;
        int end = 0;
        while (n-- > 0) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("push")) {
                que[end++] = Integer.parseInt(line[1]);
            } else if (line[0].equals("pop")) {
                if (begin == end) {
                    System.out.println(-1);
                } else {
                    System.out.println(que[begin]);
                    begin += 1;
                }
            } else if (line[0].equals("size")) {
                System.out.println(end - begin);
            } else if (line[0].equals("empty")) {
                if (begin == end) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (line[0].equals("front")) {
                if (begin == end) {
                    System.out.println(-1);
                } else {
                    System.out.println(que[begin]);
                }
            } else if (line[0].equals("back")) {
                if (begin == end) {
                    System.out.println(-1);
                } else {
                    System.out.println(que[end - 1]);
                }
            }
        }
    }
}
