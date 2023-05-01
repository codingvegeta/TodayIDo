package programmers.level0.test51_100;

import java.util.ArrayList;

// 할 일 목록
public class Test70 {
    public ArrayList<String> solution(String[] todo_list, boolean[] finished) {
        ArrayList<String> answer = new ArrayList();
        for(int i=0; i<todo_list.length; i++){
            if(!finished[i]){
                answer.add(todo_list[i]);
            }
        }
        return answer;
    }
}
