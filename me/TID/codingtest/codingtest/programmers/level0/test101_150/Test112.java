package programmers.level0.test101_150;

import java.util.ArrayList;
import java.util.Arrays;

public class Test112 {
    public ArrayList<String> solution(String my_str, int n) {
        ArrayList<String> answer = new ArrayList();
        int count =0;
        for(int i=0; count < my_str.length() ; i++){
            if(my_str.length() - count > n){
                answer.add(my_str.substring(count,count+n));
            }else{
                answer.add(my_str.substring(count, my_str.length()));
            }
            count += n;
        }
        return answer;
    }
}
