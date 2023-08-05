package programmers.level0.test101_150;
// 수열과 구간 쿼리4
public class Test126 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        for(int i = 0; i< arr.length; i++)
        {
            answer[i] = arr[i];

            for(int j = 0; j< queries.length; j++){
                if(i >= queries[j][0] && i <= queries[j][1]){
                    if(i % queries[j][2] == 0){
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }
}
