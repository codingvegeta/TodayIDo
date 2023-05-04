package programmers.level0.test51_100;
// 문자열 뒤집기
public class Test98 {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        for(int i=0; i<s; i++){
            answer+= my_string.charAt(i);
        }
        for(int i=e; i>=s; i--){
            answer+= my_string.charAt(i);
        }
        for(int i=e+1; i<my_string.length(); i++){
            answer+= my_string.charAt(i);
        }
        return answer;
    }
}
