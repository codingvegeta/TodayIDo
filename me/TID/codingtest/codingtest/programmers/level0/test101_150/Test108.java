package programmers.level0.test101_150;

import java.util.ArrayList;

// 세 개의 구분자
public class Test108 {
    public ArrayList<String> solution(String myStr) {
        ArrayList<String> answer = new ArrayList<>();
        int count = 0;
        String str = "";
        for(int i =0; i<myStr.length(); i++){
            char x = myStr.charAt(i);
            if (x == 'a' || x == 'b' || x == 'c') {
                String substring = myStr.substring(count, i);
                if (!substring.isBlank()) {
                    answer.add(substring);
                };
                count = i + 1;
            }
        }
        if (count < myStr.length()) {
            answer.add(myStr.substring(count, myStr.length()));
        };
        if(answer.size() == 0){
            answer.add("EMPTY");
        }
        return answer;
    }
}
