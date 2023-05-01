package programmers.level0.test1_50;

public class Test4 {
    static int solution(int n, int m) {
        int answer = 0;
        int d = n;
        while(n>1){
            answer++;
            n-=1;
        }
        int sum = 0;
        while(m>1){
            sum++;
            m-=1;
        }
        sum=d*sum;
        return answer+sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 2));
        System.out.println(solution(2, 5));
        System.out.println(solution(1, 1));
    }
}
