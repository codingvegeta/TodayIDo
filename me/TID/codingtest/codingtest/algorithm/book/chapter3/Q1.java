package algorithm.book.chapter3;

import java.util.Scanner;

public class Q1 {
    static int seqSearchSen(int[] a, int n, int key) {
        int i = 0;
            a[n] = key;             // 보초를 추가

        for (i = 0; i < a.length; i++) {
                if (a[i] == key)    // 검색 성공
                    break;
            }
            return i == n ? -1 : i;
        }

        public static void main (String[]args){
            Scanner stdIn = new Scanner(System.in);

            System.out.print("요솟수 : ");
            int num = stdIn.nextInt();
            int[] x = new int[num + 1];                        // 요솟수가 num + 1인 배열

            for (int i = 0; i < num; i++) {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            }

            System.out.print("검색 값 : ");                    // 키값을 읽력받음
            int ky = stdIn.nextInt();

            int idx = seqSearchSen(x, num, ky);              // 배열 x에서 값이 ky인 요소를 검색

            if (idx == -1)
                System.out.println("검색 값의 요소가 없습니다.");
            else
                System.out.println("검색 값은 x[" + idx + "]에 있습니다.");
        }
    }


