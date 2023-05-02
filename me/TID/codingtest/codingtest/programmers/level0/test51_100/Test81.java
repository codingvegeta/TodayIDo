package programmers.level0.test51_100;
// l로 만들기
public class Test81 {
    public String solution(String myString) {
        String answer = "";
        for(char x : myString.toCharArray()){
            if (x-'l' < 0){
                answer+='l';
            }else{
                answer+=x;
            }
        }
        return answer;
    }
}
