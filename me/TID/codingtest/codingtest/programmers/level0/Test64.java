package programmers.level0;

import java.util.Arrays;

// 접미사 배열
public class Test64 {
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        int p = 0;
        for(int i =my_string.length()-1; i>=0; i--){
            String str = my_string.substring(i);
            answer[p++]=str;
        }
        Arrays.sort(answer);
        return answer;
    }
}
