package programmers.level0.test1_50;

import java.util.Arrays;

public class Test40 {
    public int[] solution(int[] numbers, String direction){
        int n = numbers.length;
        int[] answer = new int[n];
        if (direction.equals("right")){
            int p = 0;
            answer[p++] = numbers[n-1];
            for(int i=0; i< n-1; i++){
                answer[p++] = numbers[i];
            }
        }else{
            answer[n-1] = numbers[0];
            int p = 0;
            for(int i=1; i< n; i++){
                answer[p++] = numbers[i];
            }
        }
        return answer;
    }
}
