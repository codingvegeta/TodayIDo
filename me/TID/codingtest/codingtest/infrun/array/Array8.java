package infrun.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Array8 {
    static String solution(int[] d) {
        StringBuilder sb = new StringBuilder();
        Integer[] p = new Integer[d.length];
        for (int i = 0; i < p.length; i++) {
            p[i] = d[i];
        }
        int[] t = new int[d.length];
        for (int i = 0; i < t.length; i++) {
            t[i] = i + 1;
        }
        Arrays.sort(p, Collections.reverseOrder());
        for (int i = 1; i < p.length; i++) {
            if (p[i-1] == p[i]) {
                t[i] = t[i - 1];
            }
        }
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (d[i] == p[j]) {
                    sb.append(t[j]+" ");
                    break;
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < d.length; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println(solution(d));
    }
}
