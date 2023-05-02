package programmers.level0.test51_100;
//가까운 1 찾기
public class Test84 {
    public int solution(int[] arr, int idx) {
        int answer = -1;
        for(int i=0; i<arr.length; i++){
            if(i >= idx && arr[i] == 1){
                return i;
            }
        }
        return answer;
    }
}
