package programmers.level0;
// 주사위의 개수
public class Test28 {
    public int solution(int[] box, int n) {
        int answer = (box[0] / n) * (box[1] / n) * (box[2] / n);
        return answer;
    }
}
