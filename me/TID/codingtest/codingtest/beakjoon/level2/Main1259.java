package beakjoon.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        while (true) {
//            String str = br.readLine();
//            char[] cha = str.toCharArray();
//            for (int i = 0; i < cha.length / 2 ; i++) {
//                char temp = cha[i];
//                cha[i] = cha[cha.length - 1 - i];
//                cha[cha.length - 1 - i] = temp;
//            }
//            if (str.equals("0")) {
//                break;
//            }
//            String s = String.valueOf(cha);
//            if (str.equals(s)) {
//                System.out.println("yes");
//            } else {
//                System.out.println("no");
//            }
//        }
        while (true) {
            String str = br.readLine();
            if (str.equals("0")) {
                return;
            }
            char[] cha = str.toCharArray();
            int i = 0;
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            while (i < cha.length) {
                stack.push(cha[i++]);
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            if (str.equals(sb.toString())) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
