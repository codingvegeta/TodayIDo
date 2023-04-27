package programmers.level0;

// 더 크게 합치기
public class Test14 {
    public int solution(int a, int b) {
        int t1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int t2 = Integer.parseInt(String.valueOf(b) + String.valueOf(a));
        return Math.max(t1,t2);
    }
}
