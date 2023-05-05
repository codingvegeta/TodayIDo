package programmers.level0.test101_150;

import java.util.Stack;

// 컨트롤 제트
public class Test101 {
    static int solution(String s) {
        int answer = 0;
        String[] d = s.split(" ");
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<d.length; i++){
            String x = d[i];
            if(!x.equals("Z")){
                answer+=Integer.parseInt(x);
                st.push(Integer.parseInt(x));
            }else {
                answer-=st.pop();
            }
        }
        return answer;
    }
}
