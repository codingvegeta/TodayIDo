package sungmok;

import java.util.Arrays;

public class T {
        static int solution(int price) {
            int answer = 0;
            if(price >= 100000){
                answer =(int) (price * 0.95);
            }else if(price >= 300000){
                answer =(int) (price * 0.90);
            }else if(price >= 500000){
                answer =(int) (price * 0.80);
            }else
                answer = price;
            return answer;
        }
    public static void main(String[] args) {
//        System.out.println(solution("nice to meet you"));
//        System.out.println(solution(580000));
        int[] d = new int[]{1, 2, 3, 4};
    }
}
