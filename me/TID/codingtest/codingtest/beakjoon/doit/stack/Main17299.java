package beakjoon.doit.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        int[] ngf = new int[n];
        int[] f = new int[1000001];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            f[a[i]] += 1;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            while (!stack.isEmpty() && f[a[stack.peek()]] < f[a[i]]) {
                ngf[stack.pop()] = a[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ngf[stack.pop()] = -1;
        }
        for (int i = 0; i < ngf.length; i++) {
            sb.append(ngf[i]);
            sb.append(" ");
        }
        System.out.println(sb);

    }
}
