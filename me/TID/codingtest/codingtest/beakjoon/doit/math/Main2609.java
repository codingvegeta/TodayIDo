package beakjoon.doit.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(min(a, b));
        System.out.println(max(a, b));


    }

    static int min(int a, int b) {
        if (b == 0) {
            return a;
        }else
            return min(b, a % b);
    }

    static int max(int a, int b) {
        int r = min(a, b);
        return r * (a / r) * (b / r);
    }
}
