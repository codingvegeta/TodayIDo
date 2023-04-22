package infrun.sort;

import java.util.Scanner;

public class Sort1 {
    static int[] solution(int[] d) {
        for(int i =0; i<d.length-1; i++){
            int idx = i;
            for (int j = i + 1; j < d.length; j++) {
                if (d[idx] > d[j]) {
                    idx = j;
                }
            }
            int tmp = d[i];
            d[i] = d[idx];
            d[idx] = tmp;
        }
        return d;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        for(int x : solution(d)){
            System.out.print(x + " ");
        }
    }
}
