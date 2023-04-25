package infrun.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Sort9 {
    static int count(int[] d, int capacity) {
        int cnt = 1, sum = 0;
        for (int x : d) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else sum += x;
        }
        return cnt;
    }

    static int solution(int n, int m, int[] d) {
        int answer = 0;
        int lt = Arrays.stream(d).max().getAsInt();
        int rt = Arrays.stream(d).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(d, mid) <= m) {
                answer = mid ;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, d));
    }
}
