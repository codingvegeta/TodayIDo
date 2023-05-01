package programmers.level0.test1_50;
// 문자열 안에 문자열
public class Test13 {
    public int solution(String str1, String str2) {
        return str1.contains(str2) ? 1 : 2;
    }
}
