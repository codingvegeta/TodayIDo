package programmers.level0.test101_150;
// 7의 개수
public class Test106 {
    public int solution(int[] array) {
        int answer = 0;
        for(int i =0 ; i<array.length; i++){
            while (array[i]>0){
                int a = array[i] % 10;
                if(a == 7){
                    answer++;
                }
                array[i]/=10;
            }
        }
        return answer;
    }
}
