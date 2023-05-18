package programmers.level0.test101_150;

import java.util.ArrayList;

// 소인수분해
public class Test105 {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=2; i<=n; i++){
            if(n % i == 0){
                while(n % i == 0){
                    n /= i;
                }
                answer.add(i);
            }
        }
        return answer;
    }
}
