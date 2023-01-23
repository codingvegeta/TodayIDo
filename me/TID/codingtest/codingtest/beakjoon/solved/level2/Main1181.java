package beakjoon.solved.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        while (n-- > 0) {
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>(set);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                   return String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
                }
            }
        });
        for (String str:list) {
            System.out.println(str);
        }
        br.close();
    }
}

