package beakjoon.doit.brute;

import java.io.*;

public class Main3085 {
    static int check(char[][] a) {
        int n = a.length;
        int answer = 1;
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 1; j < n; j++) {
                if (a[i][j] == a[i][j - 1]) {
                    count += 1;
                } else {
                    count = 1;
                }
                if (answer < count) answer = count;
            }
            count = 1;
            for (int j = 1; j < n; j++) {
                if (a[j][i] == a[j - 1][i]) {
                    count += 1;
                } else {
                    count = 1;
                }
                if (answer < count) answer = count;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] a = new char[n][n];
        for (int i = 0; i <n ; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = str.charAt(j);
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    char t = a[i][j];
                    a[i][j] = a[i][j+1];
                    a[i][j + 1] = t;
                    int temp = check(a);
                    if (answer < temp) answer = temp;
                    t= a[i][j];
                    a[i][j] = a[i][j+1];
                    a[i][j + 1] = t;
                }
                if (i + 1 < n) {
                    char t = a[i][j];
                    a[i][j] = a[i + 1][j];
                    a[i+1][j] = t;
                    int temp = check(a);
                    if (answer < temp) answer = temp;
                    t = a[i][j];
                    a[i][j] = a[i + 1][j];
                    a[i + 1][j] = t;
                }
            }
        }
        bw.write(answer + "\n");
        bw.close();
    }
}
