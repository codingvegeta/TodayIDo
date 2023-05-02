package programmers.level0.test51_100;

import java.util.*;

public class Test82 {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            int count = 1;
            for (int j = 0; j < emergency.length; j++) {
                if (emergency[i] < emergency[j]) {
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}