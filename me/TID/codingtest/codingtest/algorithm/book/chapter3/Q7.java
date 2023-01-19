package algorithm.book.chapter3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Q7 {
    static class PhyscData {
        private String name;          // 이름
        private int height;        // 키
        private double vision;        // 시력

        //--- 생성자(constructor) ---//
        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        //--- 문자열로 만들어 반환하는 메서드 --//
        public String toString() {
            return name + " " + height + " " + vision;
        }

        //--- 키의 오름차순으로 정렬하기 위한 comparator ---//
        public static final Comparator<PhyscData> VISION_ORDER =
                new VisionOrderComparator();

        private static class VisionOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                if (d1.vision < d2.vision) {
                    return -1;
                } else if (d1.vision > d2.vision) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PhyscData[] x = {                    // 키의 오름차순으로 정렬
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("황지안", 169, 0.8),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("박준서", 175, 2.0),
        };

        System.out.print("시력이 ?? 인 사람을 찾고 있나요?: ");
        double vision = stdIn.nextDouble();                // 킷값을 읽어 들임
        int idx = Arrays.binarySearch(
                x,                                 // 배열 x에서
                new PhyscData("", 0, vision),    // 키가 height인 요소를
                PhyscData.VISION_ORDER             // HEIGHT_ORDER에 의해 검색
        );

        if (idx < 0)
            System.out.println("그 값의 요소가 없습니다.");
        else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터: " + x[idx]);
        }
    }
}

