package programmers.level0.test101_150;
// 배열의 길이를 2의 거듭제곱으로 만들기
public class Test124 {
    public int[] solution(int[] arr) {
        int[] answer;

        if (arr.length == 1) {
            return arr;
        }

        for (int i = 1; i <= 1024; i = i * 2) {
            if (arr.length < i) {
                answer = new int[i];
                for (int j = 0; j < arr.length; j++) {
                    answer[j] = arr[j];
                }
                for (int j = arr.length; j < i; j++) {
                    answer[j] = 0;
                }
                return answer;
            } else if (arr.length == i) {
                return arr;
            }
        }
        return null;
    }
}
