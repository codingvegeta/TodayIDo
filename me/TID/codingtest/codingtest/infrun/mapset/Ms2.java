package infrun.mapset;

import java.util.HashMap;
import java.util.Scanner;

public class Ms2 {
    static String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char x:str1.toCharArray()) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }
        for(char x:str2.toCharArray()){
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }
        if (map1.size() != map2.size()) {
            sb.append("NO");
            return sb.toString();
        }
        for(char x:map1.keySet()){
            int n = map1.get(x);
            int m = map2.get(x);
            if(n != m){
                sb.append("NO");
                break;
            }
        }
        if (sb.length() == 0) {
            sb.append("YES");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1, str2));
    }
}
