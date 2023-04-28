package programmers.level0;

import java.util.ArrayList;
// n의 배수 고르기
public class Test34 {
    public ArrayList<Integer> solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList();
        for(int x : numlist){
            if(x % n == 0){
                list.add(x);
            }
        }
        return list;
    }
}
