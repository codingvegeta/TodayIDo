package programmers.level0.test51_100;

// 특별한 이차원 배열 2
public class Test69 {
    public int solution(int[][] arr) {
        int answer = 1;
        for(int i =0; i<arr.length; i++){
            for(int j =0; j<arr.length; j++){
                if(arr[i][j] != arr[j][i]){
                    return 0;
                }
            }
        }
        return answer;
    }
}
