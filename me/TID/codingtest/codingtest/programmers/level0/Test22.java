package programmers.level0;

// 암호 해독
public class Test22 {
    public String solution(String cipher, int code) {
        String answer = "";
        int count = 1;
        for(char x : cipher.toCharArray()){
            if (count % code == 0){
                answer+=x;
            }
            count++;
        }
        return answer;
    }
}
