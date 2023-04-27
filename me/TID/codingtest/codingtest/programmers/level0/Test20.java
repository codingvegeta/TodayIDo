package programmers.level0;

// 수 조작하기
public class Test20 {
    public int solution(int n, String control) {
        for(char x : control.toCharArray()){
            if( x == 'w'){
                n += 1;
            }else if(x == 's'){
                n -= 1;
            }else if(x == 'd'){
                n+=10;
            }else{
                n-=10;
            }
        }
        return n;
    }
}
