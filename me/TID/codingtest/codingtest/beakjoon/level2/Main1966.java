package beakjoon.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 3
 * 1 0
 * 5
 * 4 2
 * 1 2 3 4
 * 6 0
 * 1 1 9 1 1 1
 */
public class Main1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        System.out.println("n = " + n);
        while (true) {
            System.out.println("Integer.parseInt(st.nextToken()) = " + Integer.parseInt(st.nextToken()));
        }
    }
}
