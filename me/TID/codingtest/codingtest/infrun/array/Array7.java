package infrun.array;

import java.util.Scanner;

public class Array7 {
    static int solution(int[] d) {
        int answer = 0;
        int count = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            answer += count;
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < d.length; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println(solution(d));
    }
}
