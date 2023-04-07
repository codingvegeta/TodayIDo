package infrun.array;

import java.util.Arrays;
import java.util.Scanner;

public class Array9 {
    static int solution(int[][] d) {
        int answer = 0;
        for (int i = 0; i < d.length; i++) {
            int sum = 0;
            for (int j = 0; j < d[i].length; j++) {
                sum += d[i][j];
            }
            if (answer < sum) {
                answer = sum;
            }
        }
        for (int i = 0; i < d.length; i++) {
            int sum = 0;
            for (int j = 0; j < d.length; j++) {
                sum += d[j][i];
            }
            if (answer < sum) {
                answer = sum;
            }
        }
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i][i];
        }
        if (answer < sum) {
            answer = sum;
        }
        sum = 0;
        for (int i = d.length - 1; i >= 0; i--) {
            sum += d[i][i];
        }
        if (answer < sum) {
            answer = sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(d));
    }
}
