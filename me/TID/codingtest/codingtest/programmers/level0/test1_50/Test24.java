package programmers.level0.test1_50;

// 대문자와 소문자
public class Test24 {
    public String solution(String my_string) {
        String answer = "";
        for(char x : my_string.toCharArray()){
            if (x - 'a' >= 0){
                answer += Character.toUpperCase(x);
            }else{
                answer += Character.toLowerCase(x);
            }
        }
        return answer;
    }
}
