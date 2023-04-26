package sungmok;

import java.util.ArrayList;

public class N {
    static int solution(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        int lt = 0;
        int rt = lt + 1;
        while (rt < list.size()) {
            char x1 = list.get(lt);
            char x2 = list.get(rt);
            if (x1 == x2) {
                if (rt < list.size()-1) {
                    while (x1 == list.get(rt)) {
                        rt++;
                    }
                } else {
                    rt++;
                }
                for (int i = lt; i < rt; i++) {
                    list.remove(lt);
                }
                lt = 0;
                rt = lt + 1;
            } else {
                lt++;
                rt++;
            }
        }
        if (list.size() > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String str = "saasaaaaassaasaasaa";
        System.out.println(solution(str));
        String str2 = "cdcd";
        System.out.println(solution(str2));
    }
}
