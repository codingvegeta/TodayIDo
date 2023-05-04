package programmers.level0.test51_100;
// 두 수의 연산값 비교하기
public class Test100 {
    public int solution(int a, int b) {
        return Integer.parseInt(String.valueOf(a+""+b)) > 2 * a * b ? Integer.parseInt(String.valueOf(a+""+b)) : 2 * a * b;
    }
}
