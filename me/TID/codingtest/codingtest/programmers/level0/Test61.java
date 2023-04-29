package programmers.level0;
// 문자열 정렬하기 (2)
import java.util.Arrays;

public class Test61 {
    public String solution(String my_string) {
        char[] c = my_string.toLowerCase().toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
