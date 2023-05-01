package programmers.level0.test1_50;

public class Test27 {
    static int solution(int[] numbers, int n) {
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            answer += numbers[i];
            if (answer > n) return answer;
        }
        return answer;
    }
}
