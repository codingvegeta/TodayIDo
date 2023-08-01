package programmers.level0.test101_150;
// 리스트 자르기

import java.util.ArrayList;

public class Test125 {
    public ArrayList<Integer> solution(int n, int[] slicer, int[] num_list) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        if(n == 1){
            for(int i = 0; i <= slicer[1]; i++){
                answer.add(num_list[i]);
            }
        }else if (n == 2){
            for(int i = slicer[0]; i<num_list.length; i++){
                answer.add(num_list[i]);
            }
        }else if(n==3){
            for(int i = slicer[0]; i <= slicer[1]; i++){
                answer.add(num_list[i]);
            }
        }else{
            for(int i = slicer[0]; i<= slicer[1]; i+=slicer[2]){
                answer.add(num_list[i]);
            }
        }
        return answer;
    }
}
