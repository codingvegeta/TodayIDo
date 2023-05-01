package programmers.level0.test1_50;
// 홀짝에 따라 다른 값 변환하기
public class Test18 {
    public int solution(int n) {
        int answer = 0;
        if (n % 2 == 0) {
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    answer += i * i;
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) {
                    answer += i;
                }
            }
        }
        return answer;
    }
}
