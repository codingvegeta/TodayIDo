package programmers.level0.test101_150;
//qr code
public class Test127 {
    public String solution(int q, int r, String code) {
        String answer = "";
        for(int i = 0; i< code.length(); i++){
            if(i % q == r){
                answer+=code.charAt(i);
            }
        }
        return answer;
    }
}
