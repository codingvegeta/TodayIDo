package programmers.level0.test51_100;

import java.util.Arrays;

// 2치원으로 만들기
public class Test73 {
    static int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        int p = 0;
        for (int i = 0; i < num_list.length / n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = num_list[p++];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2)));
    }
}
