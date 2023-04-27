package programmers.level0;

// 가위 바위 보
public class Test26 {
    public String solution(String rsp) {
        String answer = "";
        for(char x : rsp.toCharArray()){
            if(x == '2'){
                answer+=0;
            }else if(x == '0'){
                answer += 5;
            }else {
                answer += 2;
            }
        }
        return answer;
    }
}
