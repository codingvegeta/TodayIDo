package programmers.level0.test101_150;
//문자열 계산하기

public class Test115 {
    public int solution(String my_string) {
        int answer = 0;
        String[] str = my_string.split(" ");
        answer+=Integer.parseInt(str[0]);
        for(int i=1; i<str.length; i++){
            if(str[i].equals("+")){
                answer += Integer.parseInt(str[i+1]);
            }else if(str[i].equals("-")){
                answer -= Integer.parseInt(str[i+1]);
            }
        }
        return answer;
    }
}
