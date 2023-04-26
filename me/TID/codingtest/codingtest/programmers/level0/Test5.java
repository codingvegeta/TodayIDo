package programmers.level0;

import java.util.ArrayList;

// 배열 조각하기
public class Test5 {
    static int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        for (int i = 0; i < query.length; i++) {
            int pos = query[i];
            if (pos % 2 == 0) {
                for (int j = pos + 1; j < list.size(); j++) {
                    list.remove(pos + 1);
                }
            } else {
                for (int j = pos - 1; j >= 0; j--) {
                    list.remove(pos - 1);
                }
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};
        for (int x : solution(arr, query)) {
            System.out.println(x);
        }
    }

}
