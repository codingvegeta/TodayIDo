package infrun.stack_que;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sq7 {
    static String solution(String str1, String str2) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for(char x : str1.toCharArray()) q.offer(x);
        for(char x : str2.toCharArray()){
            if (q.contains(x)) {
                if (x != q.peek()) {
                    return answer;
                }
            }
        }
        if (!q.isEmpty()) {
            return "NO";
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
