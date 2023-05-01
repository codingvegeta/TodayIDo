package programmers.level0.test1_50;

// 세균 증식
public class Test25 {
    public int solution(int n, int t) {
        int answer = n;
        for(int i = 0; i<t; i++){
            answer*=2;
        }
        return answer;
    }
}
