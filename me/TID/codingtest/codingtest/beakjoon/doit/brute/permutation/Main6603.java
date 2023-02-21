package beakjoon.doit.brute.permutation;

import java.io.*;
import java.util.*;

public class Main6603 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            int[] a = new int[n];
            int[] d = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++) {
                if (i < n - 6) d[i] = 0;
                 else d[i] = 1;
            }
            ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

            do {
                ArrayList<Integer> cur = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (d[i] == 1) {
                        cur.add(a[i]);
                    }
                }
                answer.add(cur);
            } while (next(d));
            Collections.sort(answer, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int n = o1.size();
                    int m = o2.size();
                    int i = 0;
                    while (i < n && i < m) {
                        int t1 = o1.get(i);
                        int t2 = o2.get(i);
                        if (t1 < t2) return -1;
                        else if (t1 > t2) return 1;
                        i += 1;
                    }
                    if (i==n && i!=m) return -1;
                    else if (i!=n && i == m) return 1;
                    return 0;
                }
            });
            for (ArrayList<Integer> v : answer) {
                for (Integer x : v) {
                    bw.write(x + " ");
                }
                bw.write("\n");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
