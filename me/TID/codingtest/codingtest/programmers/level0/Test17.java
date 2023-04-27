package programmers.level0;
// 제곱수 판별하기
public class Test17 {
    public int solution(int n) {
        double d = Math.sqrt(n);
        if(n % d == 0){
            return 1;
        }else{
            return 2;
        }
    }
}
