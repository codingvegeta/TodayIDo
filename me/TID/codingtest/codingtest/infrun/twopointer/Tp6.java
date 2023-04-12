package infrun.twopointer;

import java.util.Scanner;

public class Tp6 {
    static int solution(int t, int[] d) {
        int answer = 0;
        for (int lt = 0; lt < d.length; lt++) {
            int sum = d[lt];
            int counter = t;
            for (int rt = lt + 1; rt < d.length; rt++) {
                if (d[rt] > 0) {
                    sum += d[rt];
                } else if (d[rt] == 0) {
                    if (counter == 0) {
                        break;
                    }
                    counter--;
                    sum += 1;
                }
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println(solution(t, d));
    }
}
