package programmers.level0;

import java.util.Arrays;

//문자열 정렬하기(1)
public class Test32 {
    public int[] solution(String my_string) {
        int count = 0;
        for(char x : my_string.toCharArray()){
            if(Character.isDigit(x)){
                count++;
            }
        }
        int[] answer = new int[count];
        count=0;
        for(char x : my_string.toCharArray()){
            if(Character.isDigit(x)){
                answer[count++]=x-'0';
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}
