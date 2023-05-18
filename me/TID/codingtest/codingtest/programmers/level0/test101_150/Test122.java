package programmers.level0.test101_150;

import java.util.Arrays;

//조건에 맞게 수열 변환하기2
public class Test122 {
    public int solution(int[] arr) {
        int answer = 0;
        int[] d = arr.clone();
        while(true){
            for(int i=0; i<arr.length; i++){
                if(arr[i] >= 50 && arr[i] % 2 == 0){
                    arr[i] = arr[i] /2;
                }
                if(arr[i] <50 && arr[i] % 2 != 0){
                    arr[i] = arr[i] * 2 + 1;
                }
            }
            if(Arrays.equals(arr,d)){
                return answer;
            }else{
                d = arr.clone();
                answer++;
            }
        }
    }
}
