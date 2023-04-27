package programmers.level0;

// 뒤에서 5등 위로
import java.util.*;
public class Test9 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length - 5];
        Arrays.sort(num_list);
        int p = 0;
        for(int i = 5; i<num_list.length; i++){
            answer[p++] = num_list[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(10 % 4);
    }
}
