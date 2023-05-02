package programmers.level0.test51_100;
// 등차수열의 특정한 항만 더하기
public class Test90 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for(int i = 0; i<included.length; i++){
            int sum = a +(d*i);
            if(included[i]){
                answer+=sum;
            }
        }
        return answer;
    }
}
