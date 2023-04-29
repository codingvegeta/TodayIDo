package programmers.level0;

public class Test59 {
    public int solution(int n) {
        int answer = 0;
        boolean[] d = new boolean[n+1];
        for(int i =2; i<=n; i++){
            for(int j = 2; i*j<=n; j++){
                d[i*j]=true;
            }
        }
        for(int i =0; i < d.length; i++){
            if(d[i]){
                answer++;
            }
        }
        return answer;
    }
}
