package programmers.level0.test1_50;
// 글자 이어붙여 문자열 만들기
public class Test39 {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        for(int i = 0; i<index_list.length; i++){
            answer+=my_string.charAt(index_list[i]);
        }
        return answer;
    }
}
