package infrun.twopointer;

import java.util.Scanner;

public class Tp1 {
    static int[] solution(int n, int m, int[] a, int[] b) {
        int[] answer = new int[n + m];
        int ap = 0;
        int bp = 0;
        while (ap + bp < n + m) {
            if (a[ap] < b[bp]) {
                answer[ap + bp] = a[ap];
                ap++;
            } else if (a[ap] > b[bp]) {
                answer[ap + bp] = b[bp];
                bp++;
            } else {
                answer[ap + bp] = a[ap];
                ap++;
                answer[ap + bp] = b[bp];
                bp++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        a[a.length - 1] = Integer.MAX_VALUE;
        int m = sc.nextInt();
        int[] b = new int[m + 1];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        b[b.length - 1] = Integer.MAX_VALUE;
        for (int x : solution(n, m, a, b)) {
            System.out.print(x + " ");
        }
    }
}
