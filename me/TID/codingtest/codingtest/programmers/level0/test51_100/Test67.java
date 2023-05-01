package programmers.level0.test51_100;

import java.util.ArrayList;

// 콜라츠 수열 만들기
public class Test67 {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        while(n > 1){
            if (n%2==0){
                n/=2;
                list.add(n);
            }else{
                n=3*n+1;
                list.add(n);
            }
        }
        return list;
    }
}
