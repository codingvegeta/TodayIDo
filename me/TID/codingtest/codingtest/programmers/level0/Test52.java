package programmers.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test52 {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        Collections.sort(list);
        return list;
    }
}
