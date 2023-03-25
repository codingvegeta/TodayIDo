package beakjoon.solved;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1018 {
    static String answer1 = "WBWBWBWB";
    static String answer2 = "BWBWBWBW";
    static int go(char[][] d) {
        int answer = 0;
        for (int i = 0; i < d.length - 1; i++) {
            for (int j = 0; j < d[0].length - 1; j++) {
                if (j == d.length - 1) {
                    if (d[i][j] != d[i + 1][0]) {
                        answer++;
                    }
                }
                if (d[i][j] == 'B') {

                }
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {

            }
        }

//        char[][] d = new char[n][m];
//        for (int i = 0; i <n; i++) {
//                d[i] = br.readLine().toCharArray();
//        }


    }
}
