package infrun.array;

import java.util.Scanner;

public class Array2 {
    static int solution(int[] d) {
        int answer = 1;
        int student = d[0];
        for(int i = 1; i< d.length;i++) {
            if (student < d[i]) {
                student = d[i];
                answer++;
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
        System.out.println(solution(d));
    }
}
