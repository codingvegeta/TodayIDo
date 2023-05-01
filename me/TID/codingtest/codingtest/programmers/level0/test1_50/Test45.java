package programmers.level0.test1_50;

//원하는 문자열 찾기
public class Test45 {
    public int solution(String myString, String pat) {
        return myString.toUpperCase().contains(pat.toUpperCase()) ? 1:0;
    }
}
