package programmers.level0.test51_100;

import java.util.Arrays;
// 한 번만 등장한 문자
public class Test89 {
    public String solution(String s) {
        String answer = "";
        for(int i =0; i<s.length(); i++){
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                answer+=s.charAt(i);
            }
        }
        char[] d = answer.toCharArray();
        Arrays.sort(d);
        answer = new String(d);
        return answer;
    }
}
