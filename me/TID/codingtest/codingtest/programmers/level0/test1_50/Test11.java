package programmers.level0.test1_50;

// n 번째 원소부터
public class Test11 {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length - n +1];
        int p = 0;
        for(int i = n-1; i< num_list.length; i++){
            answer[p++] = num_list[i];
        }
        return answer;
    }
}
