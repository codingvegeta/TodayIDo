package programmers.level0.test51_100;
//가까운 수
public class Test80 {
    public int solution(int[] array, int n) {
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<array.length; i++){
            int a = Math.abs(answer - n);
            int b = Math.abs(array[i] - n);
            if (a > b) {
                answer = array[i];
            }else if (a == b){
                answer = answer > array[i] ? array[i] : answer ;
            }
        }
        return answer ;
    }
}
