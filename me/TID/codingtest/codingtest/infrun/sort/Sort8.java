package infrun.sort;

import java.util.*;

public class Sort8 {
    static int solution(int n, int m, int[] d) {
        int answer = 0;
        Arrays.sort(d);
        int lt = 0, rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (d[mid] == m) {
                answer = mid + 1;
                break;
            }
            if (d[mid]>m) rt = mid - 1;
            else lt = mid + 1;
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
