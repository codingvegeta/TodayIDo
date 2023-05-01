package programmers.level0.test51_100;
// 9로 나눈 나머지
public class Test76 {
    public int solution(String number) {
        int answer = 0;
        for(char x : number.toCharArray()){
            int n = x - '0';
            answer+=n;
        }
        answer = answer % 9;
        return answer;
    }
}
