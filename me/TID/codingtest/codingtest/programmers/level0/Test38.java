package programmers.level0;

import java.util.ArrayList;

// n개 간격의 원소들
public class Test38 {
    public ArrayList<Integer> solution(int[] num_list, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0; i< num_list.length; i++){
            if(i%n ==0 ){
                list.add(num_list[i]);
            }
        }
        return list;
    }
}
