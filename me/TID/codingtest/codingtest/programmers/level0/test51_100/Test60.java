package programmers.level0.test51_100;

// 마지막 두 원소
public class Test60 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        for(int i =0 ; i<num_list.length; i++){
            answer[i] = num_list[i];
        }
        if(num_list[num_list.length-1] > num_list[num_list.length-2]){
            answer[answer.length-1] = num_list[num_list.length-1] - num_list[num_list.length-2];
        }else{
            answer[answer.length-1] = 2 * num_list[num_list.length-1];
        }
        return answer;
    }
}
