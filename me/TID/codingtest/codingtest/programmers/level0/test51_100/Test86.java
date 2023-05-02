package programmers.level0.test51_100;

import java.util.ArrayList;

// 배열 만들기 3
public class Test86 {
    public ArrayList<Integer> solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=intervals[0][0]; i<=intervals[0][1]; i++){
            answer.add(arr[i]);
        }
        for(int i=intervals[1][0]; i<=intervals[1][1]; i++){
            answer.add(arr[i]);
        }
        return answer;
    }
}
