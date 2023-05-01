package programmers.level0.test51_100;
// 배열의 원소 삭제하기
public class Test65 {
    public int[] solution(int[] arr, int[] delete_list) {
        int count =arr.length;
        for(int i=0; i<arr.length; i++){
            for(int j =0; j<delete_list.length; j++){
                if(arr[i] == delete_list[j]){
                    count--;
                    arr[i] = 0;
                }
            }
        }
        int[] answer = new int[count];
        count = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] >0){
                answer[count++] = arr[i];
            }
        }
        return answer;
    }
}
