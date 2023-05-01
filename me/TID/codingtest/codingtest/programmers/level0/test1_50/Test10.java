package programmers.level0.test1_50;

// 개미 군단
public class Test10 {
    public int solution(int hp) {
        int[] d = {5, 3, 1};
        int answer = 0;
        for(int i =0; i< d.length; i++){
            answer += hp/d[i];
            hp %= d[i];
        }
        return answer;
    }
}
