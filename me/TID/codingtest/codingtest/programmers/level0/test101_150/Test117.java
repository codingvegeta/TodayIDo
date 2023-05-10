package programmers.level0.test101_150;
import java.util.*;
// 빈 배열에 추가, 삭제하기
public class Test117 {
    public int[] solution(int[] arr, boolean[] flag) {
        int[] answer = {};
        Stack<Integer> st = new Stack<>();
        for(int i =0; i< arr.length; i++){
            if(flag[i]){
                int d = arr[i] * 2;
                while(d-- > 0){
                    st.push(arr[i]);
                }
            }else{
                int d = arr[i];
                while(d-- > 0){
                    st.pop();
                }
            }
        }
        answer = new int[st.size()];
        int p = 0;
        for(int x : st){
            answer[p++] = x;
        }
        return answer;
    }
}
