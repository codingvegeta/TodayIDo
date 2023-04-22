package infrun.sort;

import java.util.Scanner;

public class Sort6 {
    static int[] solution(int[] d) {
        int[] answer = new int[2];
        for (int i = 0; i < d.length - 1; i++) {
            int chulsu = 0;
            if (d[i] > d[i + 1]) {
                for (int j = i; j >= 0; j--) {
                    if (d[j] > d[j - 1]) {
                        answer[0] = j + 1;
                        break;
                    }
                }
                chulsu = d[i];
            }
            if (chulsu > 0) {
                for (int j = 0; j < d.length; j++) {
                    if (chulsu >= d[j]) {
                        answer[1]++;
                    }
                }
                return answer;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        for (int x : solution(d)) {
            System.out.print(x + " ");
        }
    }
}
