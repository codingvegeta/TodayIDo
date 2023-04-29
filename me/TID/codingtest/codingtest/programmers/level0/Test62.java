package programmers.level0;
// 배열의 원소만큼 추가하기
public class Test62 {
    public int[] solution(int[] arr) {
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum+=arr[i];
        }
        int[] answer = new int[sum];
        int p = 0;
        for(int i=0; i < arr.length; i++){
            int count = arr[i];
            while(count-->0){
                answer[p++]=arr[i];
            }
        }
        return answer;
    }
}
