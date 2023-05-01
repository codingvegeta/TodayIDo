package programmers.level0.test51_100;

// 주사위 게임 2
public class Test68 {
    public int solution(int a, int b, int c) {
        if (a != b && a != c && b != c) {
            return a + b + c;
        } else if (a == b && a == c && b == c) {
            return (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
        } else {
            return (a + b + c) * (a * a + b * b + c * c);
        }
    }
}
