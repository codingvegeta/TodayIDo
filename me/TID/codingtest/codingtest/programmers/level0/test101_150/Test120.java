package programmers.level0.test101_150;
//날짜 비교하기
public class Test120 {
    public int solution(int[] date1, int[] date2) {
        int answer = 0;
        for(int i=0; i < date1.length; i++){
            if(date1[i] > date2[i]){
                return 0;
            }else if (date1[i] < date2[i]){
                return 1;
            }
        }
        return answer;
    }
}
