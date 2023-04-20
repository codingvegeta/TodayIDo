package programmers.level0;

import java.util.Arrays;

public class Test3 {
    static int[] solution(int num, int total) {
        int[] answer = new int[num];
        int check = num*(num+1) / 2;
        System.out.println(check);
        int start = (total - check) / num + 1;
        System.out.println(start);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = start + i ;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 12)));
        System.out.println(Arrays.toString(solution(5, 15)));
        System.out.println(Arrays.toString(solution(4, 14)));
        System.out.println(Arrays.toString(solution(5, 5)));
    }
}
