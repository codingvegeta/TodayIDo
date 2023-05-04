package programmers.level0.test51_100;
// 이진수 더하기
public class Test96 {
    static String solution(String bin1, String bin2) {
        return Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));
    }
}
