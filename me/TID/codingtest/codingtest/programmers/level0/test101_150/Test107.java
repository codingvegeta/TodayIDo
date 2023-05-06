package programmers.level0.test101_150;
// 1로 만들기
public class Test107 {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int i=0; i< num_list.length; i++){
            while(num_list[i] >1 ){
                if(num_list[i] %2 == 0){
                    num_list[i] /= 2;
                    answer++;
                }else{
                    num_list[i]-=1;
                    num_list[i]/=2;
                    answer++;
                }
            }
        }
        return answer;
    }
}
