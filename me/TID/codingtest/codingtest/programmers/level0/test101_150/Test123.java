package programmers.level0.test101_150;
// 커피 심부름
public class Test123 {
    public int solution(String[] order) {
        int answer = 0;
        for(int i = 0; i< order.length; i++){
            if(order[i].contains("cano") || order[i].contains("any")){
                answer+=4500;
            }else{
                answer+=5000;
            }
        }
        return answer;
    }
}
