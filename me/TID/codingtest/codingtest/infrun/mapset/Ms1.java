package infrun.mapset;

import java.util.HashMap;
import java.util.Scanner;

public class Ms1 {
    static String solution(int n, String str) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap();
        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = String.valueOf(key);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(n, str));
    }
}
