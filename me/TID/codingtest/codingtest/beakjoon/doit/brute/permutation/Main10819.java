package beakjoon.doit.brute.permutation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10819 {
    static boolean next(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[j] <= a[i - 1]) {
            j -= 1;
        }

        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    static int calculate(int[] a) {
        int sum = 0;
        for (int i = 1; i < a.length; i++) {
            sum += Math.abs(a[i] - a[i - 1]);
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int answer = 0;
        do {
            int temp = calculate(a);
            answer = Math.max(answer, temp);
        } while (next(a));
        bw.write(answer + "\n");
        bw.close();
    }
}
