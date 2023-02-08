package beakjoon.dd;

import java.io.*;

public class Main17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String str = br.readLine();
            int answer = palindrome(str);

            if (answer >= 2) {
                bw.write(answer - 1 + "\n");
            } else {
            bw.write(answer + "\n");
            }
        }
        bw.close();
    }

    private static int palindrome(String word) {
        int answer = 0;
        int left = 0;
        int right = word.length() - 1;

        while (left <= right) {

            if (word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            } else {
                answer = 1;

                int l = left;
                int r = right;

                l++;
                while (l <= r) {
                    if (word.charAt(l) == word.charAt(r)) {
                        l++;
                        r--;
                    } else {
                        answer++;
                        break;
                    }
                }

                l = left;
                r = right;

                r--;
                while (l <= r) {
                    if (word.charAt(l) == word.charAt(r)) {
                        l++;
                        r--;
                    } else {
                        answer++;
                        break;
                    }
                }
                    return answer;
            }
        }
        return answer;
    }
}