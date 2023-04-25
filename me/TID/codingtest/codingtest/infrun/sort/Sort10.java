package infrun.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Sort10 {
    static int count(int[] d, int distance) {
        int count = 1, pointer = d[0];
        for(int i = 1; i<d.length; i++ ){
            if (d[i] - pointer >= distance) {
                count++;
                pointer = d[i];
            }
        }
        return count;
    }

    static int solution(int n, int m, int[] d) {
        int answer = 0;
        Arrays.sort(d);
        int lt = 1;
        int rt = d[n - 1];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(d, mid) >= m) {
                lt = mid + 1;
                answer = mid;
            } else {
                rt = mid - 1;
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
