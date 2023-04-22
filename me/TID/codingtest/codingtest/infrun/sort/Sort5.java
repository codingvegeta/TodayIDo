package infrun.sort;

import java.util.HashMap;
import java.util.Scanner;

public class Sort5 {
    //        for (int i = 0; i < d.length - 1; i++) {
//            for (int j = i + 1; j < d.length; j++) {
//                if (d[i] == d[j]) {
//                    return "D";
//                }
//            }
//        }
//        return answer;
    static String solution(int[] d) {
        String answer = "U";
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < d.length; i++) {
            if (map.get(d[i]) == null) {
                map.put(d[i], map.getOrDefault(map.get(d[i]), 0));
            } else {
                return "D";
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
