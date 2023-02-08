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

                bw.write(answer + "\n");

        }
        bw.close();
    }

    private static int palindrome(String word) {
        int answer = 0;
        int left = 0;
        int right = word.length() - 1;
        String a;
        String b;

        while (left < right) {

            if (word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            } else {
                if (left < right - 1) {
                    a = new StringBuilder(word).deleteCharAt(right).toString();
                    b = new StringBuilder(a).reverse().toString();
                    if (a.equals(b)) {
                        return 1;
                    }
                }
                if (left + 1 < right) {
                    a = new StringBuilder(word).deleteCharAt(left).toString();
                    b = new StringBuilder(a).reverse().toString();
                    if (a.equals(b)) {
                        return 1;
                    }
                }
                return 2;
            }

//            } else {
//                answer = 1;
//
//                int l = left;
//                int r = right;
//
//                l++;
//                while (l <= r) {
//                    if (word.charAt(l) == word.charAt(r)) {
//                        l++;
//                        r--;
//                    } else {
//                        answer++;
//                        break;
//                    }
//                }
//
//                l = left;
//                r = right;
//
//                r--;
//                while (l <= r) {
//                    if (word.charAt(l) == word.charAt(r)) {
//                        l++;
//                        r--;
//                    } else {
//                        answer++;
//                        break;
//                    }
//                }
//                    return answer;
//            }
//        }
//        return answer;
        }
        return 0;
    }
}
