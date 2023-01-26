package beakjoon.doit.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17298My {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[n];
        int[] nge = new int[n];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n;i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                nge[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }
        for (int i = 0; i < nge.length; i++) {
            sb.append(nge[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
