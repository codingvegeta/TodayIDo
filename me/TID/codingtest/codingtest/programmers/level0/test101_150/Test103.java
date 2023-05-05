package programmers.level0.test101_150;
// 세로 읽기
public class Test103 {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        for(int i=0; i< my_string.length(); i++){
            if(i % m == c-1){
                answer+=my_string.charAt(i);
            }
        }
        return answer;
    }
}
