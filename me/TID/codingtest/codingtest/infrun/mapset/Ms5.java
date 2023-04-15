package infrun.mapset;

import java.util.*;

public class Ms5 {
    static int solution(int n, int m, int[] d) {
        int answer = -1;
        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    tSet.add(d[i] + d[j] + d[k]);
                }
            }
        }
        int counter = 0;
        for (int x : tSet) {
            counter++;
            if (counter == m) {
                return x;
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
            d[i]=sc.nextInt();
        }
        System.out.println(solution(n, m, d));
    }
}
