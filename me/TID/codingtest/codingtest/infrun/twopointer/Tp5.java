package infrun.twopointer;

import java.util.Scanner;

public class Tp5 {
    static int solution(int n) {
        int answer = 0;
        int[] d = new int[n / 2 + 1];
        for (int i = 0; i < d.length; i++) {
            d[i] = i+1;
        }
        int lt = 0;
        int sum = d[lt];
        for (int rt = 1; rt < n / 2 + 1; rt++) {
            sum += d[rt];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= d[lt++];
                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
