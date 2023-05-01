package programmers.level0.test51_100;

// 부분 문자열 이어 붙여 문자열 만들기
public class Test72 {
    static public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        for(int i = 0 ;i <my_strings.length; i++){
            int p = 0;
            answer += my_strings[i].substring(parts[i][p++], parts[i][p]+1);
        }
        return answer;
    }
}
