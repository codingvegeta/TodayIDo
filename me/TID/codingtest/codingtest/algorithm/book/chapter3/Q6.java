package algorithm.book.chapter3;

import java.util.Arrays;
import java.util.Scanner;

public class Q6 {
    public static void search(int[] x, int key) {

        System.out.println("요솟수: " + x.length);


            int idx = Arrays.binarySearch(x, key);    // 배열 x에서 값이 ky인 요소를 검색

            System.out.println("검색 값은 x[" + idx + "]에 있습니다.");
    }

    public static void main(String[] args) {
        int[] x = {15, 27, 39, 77, 92, 108, 121};
        int key = 50;
        search(x, key);
    }
}
