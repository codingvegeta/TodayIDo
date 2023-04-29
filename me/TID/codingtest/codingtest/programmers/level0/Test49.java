package programmers.level0;
// 접두사인지 확인하기
public class Test49 {
    public int solution(String my_string, String is_prefix) {
        return my_string.startsWith(is_prefix) ? 1 : 0;
    }
}
