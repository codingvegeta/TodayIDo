package infrun.twopointer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Tp2 {
    static ArrayList<Integer> solution(int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    answer.add(a[i]);
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        for (int x : solution(a, b)) {
            System.out.print(x + " ");
        }
    }
}
