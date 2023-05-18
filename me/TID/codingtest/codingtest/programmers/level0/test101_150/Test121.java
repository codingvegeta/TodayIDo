package programmers.level0.test101_150;

// 문자열 묶기
public class Test121 {
    public int solution(String[] strArr) {
        int[] d = new int[31];
        int answer = 0;
        for(int i = 0; i<strArr.length; i++){
            d[strArr[i].length()]++;
        }

        for(int i=0; i < d.length; i++){
            answer = Math.max(answer, d[i]);
        }
        return answer;
    }
}
