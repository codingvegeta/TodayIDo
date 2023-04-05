package infrun.array;

import java.util.Scanner;

public class Array5 {
    static int solution(int n){
        int answer = 0;
        int[] a = new int[n + 1];
        for (int i = 1; i < a.length; i++) {
            a[i] = i + 1;
        }
        boolean[] d = new boolean[n + 1];
        d[0]=d[1] = true;
        for (int i = 2; i < n; i++) {
            for (int j = 2; i * j <= n; j++) {
                d[i * j] = true;
            }
        }
        for (int i = 0; i < d.length; i++) {
            if (!d[i]) {
                answer++;
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
