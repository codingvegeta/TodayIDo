package infrun.mapset;

import java.util.HashMap;
import java.util.Scanner;

public class Ms4 {
    static int solution(String str1, String str2) {
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> test = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            test.put(str2.charAt(i), test.getOrDefault(str2.charAt(i), 0) + 1);
        }
        if (map.equals(test)) {
            answer++;
        }
        int pointer = str2.length();
        for (int i = 0; i < str1.length() - str2.length(); i++) {
            char word = str1.charAt(i);
            if (map.get(word) > 1) {
                map.put(word, map.get(word) - 1);
            } else if (map.get(word) == 1) {
                map.remove(word);
            }
            map.put(str1.charAt(pointer), map.getOrDefault(str1.charAt(pointer++), 0) + 1);
            if (map.equals(test)) {
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1, str2));
    }
}
