package programmers.level0.test51_100;

import java.util.ArrayList;

// 5명씩
public class Test92 {
    public ArrayList<String> solution(String[] names) {
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0; i<names.length; i++){
            if(i % 5 == 0){
                answer.add(names[i]);
            }
        }
        return answer;
    }
}
