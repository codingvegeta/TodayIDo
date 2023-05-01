package programmers.level0.test51_100;
// 특별한 이차원 배열1
public class Test75 {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for(int i =0; i< n; i++){
            for(int j = 0; j<n; j++){
                if( i==j){
                    answer[i][j] = 1;
                }
            }
        }
        return answer;
    }
}
