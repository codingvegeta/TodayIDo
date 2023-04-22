package infrun.sort;

import java.util.*;

public class Sort6A {
    static ArrayList<Integer> solution(int n, int[] d) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = d.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if (d[i] != tmp[i]) {
                answer.add(i + 1);
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
        for (int x : solution(n, d)) {
            System.out.print(x + " ");
        }
    }
}
