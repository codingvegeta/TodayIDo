package programmers.level0.test51_100;

import java.util.ArrayList;

//x 사이의 개수
public class Test99 {
    static ArrayList<Integer> solution(String myString) {
        ArrayList<Integer> answer = new ArrayList<>();
        int sum = 0;
        for(int i=0; i< myString.length(); i++){
            char x = myString.charAt(i);
            if(x != 'x'){
                sum++;
            }else{
                answer.add(sum);
                sum = 0;
            }
        }
        answer.add(sum);
        return answer;
    }
}
