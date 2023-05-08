package programmers.level0.test101_150;

import java.util.ArrayList;

// 배열 만들기 5
public class Test111 {
    public ArrayList<Integer> solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i < intStrs.length; i++){
            String str = intStrs[i].substring(s,s+l);
            Integer number = Integer.parseInt(str);
            if(number > k){
                answer.add(number);
            };
        }
        return answer;
    }
}
