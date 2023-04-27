package programmers.level0;

//배열 만들기
public class Test15 {
    public int[] solution(int n, int k) {
        int[] answer = new int[n/k];
        int p = 0;
        for(int i = 1; i<=n; i++){
            if(i % k == 0){
                answer[p++]=i;
            }
        }
        return answer;
    }
}
