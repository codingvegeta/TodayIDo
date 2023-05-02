package programmers.level0.test51_100;

import java.util.Arrays;

//0 떼기
public class Test88 {
    public String solution(String n_str) {
        int count =0;
        for(int i =0; i<n_str.length(); i++){
            if(n_str.charAt(i) == '0'){
                count++;
            }else{
                break;
            }
        }
        String answer = n_str.substring(count);
        return answer;
    }

    public String solution2(String n_str) {
        return ""+Integer.parseInt(n_str);
    }
}
