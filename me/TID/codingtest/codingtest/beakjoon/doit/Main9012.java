package beakjoon.doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n-- > 0) {
            String str = br.readLine();
            char[] chars = str.toCharArray();
            for (Character cha : chars) {
                if (cha == '(') {
                    count++;
                } else {
                    count--;
                    if (count < 0) {
                        break;
                    }
                }
            }
            if (count == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            count = 0;
        }
    }
}
