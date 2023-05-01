package programmers.level0.test51_100;

import java.util.Arrays;

// 뒤에서 5등까지
public class Test58 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[5];
        Arrays.sort(num_list);
        for(int i=0; i<5; i++){
            answer[i] = num_list[i];
        }
        return answer;
    }
}
