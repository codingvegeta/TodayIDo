package programmers.level0.test51_100;
// 순서 바꾸기
public class Test83 {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int p =0;
        for(int i=n; i<num_list.length; i++){
            answer[p++] = num_list[i];
        }
        for(int i=0; i<n; i++){
            answer[p++] = num_list[i];
        }
        return answer;
    }
}
