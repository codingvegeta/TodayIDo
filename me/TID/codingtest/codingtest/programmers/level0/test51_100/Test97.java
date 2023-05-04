package programmers.level0.test51_100;

import java.util.Stack;

public class Test97 {
    static public String solution(String my_string, int s, int e) {
        String answer = "";
        Stack<Character> st = new Stack();
        for(int i=0; i<my_string.length(); i++){
            if(i >= s && i <= e){
                st.push(my_string.charAt(i));
            }else if(i > e ){
                while(!st.isEmpty()){
                    answer+=st.pop();
                }
                answer+=my_string.charAt(i);
            }else{
                answer+=my_string.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("Progra21Sremm3", 6, 12));
    }
}
