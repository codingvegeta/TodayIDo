package programmers.level0.test51_100;
// 숨어있는 숫자의 덧셈(2)
public class Test87 {
    public int solution(String my_string) {
        int answer = 0;
        String sum = "0";
        for(int i =0; i<my_string.length(); i++){
            if(Character.isDigit(my_string.charAt(i))){
                sum+=my_string.charAt(i);
            }else{
                answer += Integer.parseInt(sum);
                sum = "0";
            }
        }
        if (!sum.equals("0")) {
            answer += Integer.parseInt(sum);
        }
        return answer;
    }

}
