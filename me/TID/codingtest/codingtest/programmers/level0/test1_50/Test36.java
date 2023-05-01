package programmers.level0.test1_50;

// 특정한 문자를 대문자로 바꾸기
public class Test36 {
    public String solution(String my_string, String alp) {
        String answer = my_string.replaceAll(alp, alp.toUpperCase());
        return answer;
    }
}
