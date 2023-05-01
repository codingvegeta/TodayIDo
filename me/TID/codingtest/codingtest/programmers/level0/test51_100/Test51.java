package programmers.level0.test51_100;
// 369게임
public class Test51 {
    public int solution(int order) {
        int answer = 0;
        String s = String.valueOf(order);
        for(char x : s.toCharArray()){
            if(x == '3'|| x == '6'|| x == '9'){
                answer++;
            }
        }
        return answer;
    }
}
