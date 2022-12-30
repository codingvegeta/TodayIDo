package beakjoon.level1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2562 {
    public static void main(String[] args) throws IOException {
        int maxIndex = 0;
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            numbers.add(sc.nextInt());
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
                maxIndex = i;
            }
        }

        System.out.println(max);
        System.out.println(maxIndex + 1);
    }
}
