package programmers.level0.test51_100;

import java.util.ArrayList;

// ad 제거하기
public class Test79 {
    public ArrayList<String> solution(String[] strArr) {
        ArrayList<String> answer = new ArrayList();
        for(int i=0; i<strArr.length; i++){
            if(!strArr[i].contains("ad")) answer.add(strArr[i]);
        }
        return answer;
    }
}
