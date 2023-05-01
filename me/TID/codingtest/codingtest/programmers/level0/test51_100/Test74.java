package programmers.level0.test51_100;
// 팩토리얼
public class Test74 {
    public int solution(int n) {
        int answer = 1;
        int count = 1;
        while(answer <= n){
            answer*=count++;
        }
        return count-2;
    }
}
