package infrun.array;

import java.util.Arrays;
import java.util.Scanner;

public class Array3 {
    static String solution(int[][] d) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d[0].length; i++) {
            if (d[0][i] == 1) {
                if (d[1][i] == 2) {
                    sb.append("B\n");
                } else if (d[1][i] == 3) {
                    sb.append("A\n");
                } else {
                    sb.append("D\n");
                }
            } else if (d[0][i] == 2) {
                if (d[1][i] == 3) {
                    sb.append("B\n");
                } else if (d[1][i] == 1) {
                    sb.append("A\n");
                } else {
                    sb.append("D\n");
                }
            } else {
                if (d[1][i] == 1) {
                    sb.append("B\n");
                } else if (d[1][i] == 2) {
                    sb.append("A\n");
                } else {
                    sb.append("D\n");
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[2][n];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                d[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(d));
    }
}
