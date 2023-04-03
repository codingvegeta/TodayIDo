package infrun.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class String10 {
    public static String solution(String str, char e) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        List<Integer> equalsNumbers = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (chars[i] == e) {
                equalsNumbers.add(i);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            int absNumber = Integer.MAX_VALUE;
            for (int j = 0; j < equalsNumbers.size(); j++) {
                if (absNumber > Math.abs(i - equalsNumbers.get(j))) {
                    absNumber = Math.abs(i - equalsNumbers.get(j));
                }
            }
        sb.append(absNumber);
        sb.append(" ");
        }
        return sb.toString();
}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        char input2 = in.next().charAt(0);
        System.out.println(solution(input1, input2));
    }
}
