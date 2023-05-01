package programmers.level0.test51_100;
// 숫자 찾기
public class Test55 {
    public int solution(int num, int k) {
        int answer = -1;
        boolean flag = false;
        int count = 0;
        int p = 0;
        while(num>0){
            count++;
            if(num % 10 == k && !flag){
                p = count;
            }
            num/=10;
        }
        if(p>0){
            answer = count-p+1;
        }
        return answer;
    }

    static public int solution2(int num, int k) {
        return ("-" + num).indexOf(String.valueOf(k));
    }

}
