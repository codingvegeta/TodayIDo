package programmers.level0.test101_150;

import java.util.LinkedList;
import java.util.Queue;

public class Test104 {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i<numbers.length; i++){
            que.offer(numbers[i]);
        }
        for(int i = 1; i<k; i++){
            for(int j=0; j<2; j++){
                int x = que.poll();
                que.offer(x);
            }
        }
        return que.poll();
    }
}
