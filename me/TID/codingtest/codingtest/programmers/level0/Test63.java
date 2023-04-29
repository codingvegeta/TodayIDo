package programmers.level0;

public class Test63 {
    public String solution(String my_string) {
        String answer = "";
        for(int i =0; i<my_string.length(); i++){
            char x = my_string.charAt(i);
            if(my_string.indexOf(x) == i){
                answer+=x;
            }
        }
        return answer;
    }
}
