package programmers.level0.test101_150;
// 수열과 구간쿼리 1
public class Test102 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr.clone();
        for(int i=0; i<queries.length; i++){
            for(int j = queries[i][0]; j<=queries[i][1]; j++){
                answer[j]++;
            }
        }
        return answer;
    }
}
