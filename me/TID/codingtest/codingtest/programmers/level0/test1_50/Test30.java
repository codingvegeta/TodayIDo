package programmers.level0.test1_50;

//최댓값 만들기
public class Test30 {
    public int solution(int[] numbers) {
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                answer = Math.max(answer, numbers[i]*numbers[j]);
            }
        }
        return answer;
    }
}
