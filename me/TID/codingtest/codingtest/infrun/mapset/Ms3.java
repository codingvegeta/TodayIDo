package infrun.mapset;

import java.util.HashMap;
import java.util.Scanner;

public class Ms3 {
    static String solution(int n, int m, int[] d) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(d[i], map.getOrDefault(d[i], 0) + 1);
        }
        sb.append(map.size() + " ");
        int pointer = m;
        for (int i = 0; i < n - m; i++) {
            if (map.get(d[i]) > 1) {
            map.put(d[i], map.get(d[i]) - 1);
            } else if (map.get(d[i]) == 1) {
                map.remove(d[i]);
            }
            map.put(d[pointer],map.getOrDefault(d[pointer++],0)+1);
            sb.append(map.size()+" ");
        }
        return sb.toString();
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
