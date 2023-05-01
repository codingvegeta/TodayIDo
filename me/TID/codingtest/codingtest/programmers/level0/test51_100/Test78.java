package programmers.level0.test51_100;
// 수 조작하기2
public class Test78 {
    public String solution(int[] numLog) {
        String answer = "";
        for(int i =1; i<numLog.length; i++){
            int x =numLog[i]-numLog[i-1];
            if(x == 1){
                answer+="w";
            }else if(x == -1){
                answer+="s";
            }else if(x == 10){
                answer+="d";
            }else{
                answer+="a";
            }
        }
        return answer;
    }
}
