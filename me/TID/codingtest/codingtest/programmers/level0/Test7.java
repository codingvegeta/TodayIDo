package programmers.level0;
// 부분 문자열인지 확인하기
public class Test7 {
    public int solution(String my_string, String target) {
        if (my_string.contains(target)){
            return 1;
        }else return 0;
    }
}
