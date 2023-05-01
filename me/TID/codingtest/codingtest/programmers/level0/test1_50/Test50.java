package programmers.level0.test1_50;
// 홀수 vs 짝수
public class Test50 {
    public int solution(int[] num_list) {
        int sumA = 0;
        int sumB = 0;
        for(int i=0; i<num_list.length; i++){
            if(i % 2 == 0){
                sumA+=num_list[i];
            }else{
                sumB+=num_list[i];
            }
        }
        return Math.max(sumA,sumB);
    }
}
