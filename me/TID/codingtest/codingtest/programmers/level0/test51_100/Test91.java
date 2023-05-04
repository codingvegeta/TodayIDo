package programmers.level0.test51_100;

public class Test91 {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length > arr2.length){
            return 1;
        }else if(arr1.length < arr2.length){
            return -1;
        }else{
            int sum1 = 0;
            int sum2 = 0;
            for(int i = 0; i<arr1.length; i++){
                sum1 += arr1[i];
                sum2 += arr2[i];
            }
            if(sum1 == sum2){
                return 0;
            }
            return sum1 > sum2 ? 1 : -1;
        }
    }
}
