package beakjoon.solved.level1;

import java.util.*;

public class Main3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        ArrayList list = new ArrayList();

        for (int i = 0; i < 10; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < nums.length; i++) {
            list.add(i, nums[i] % 42);
        }

        Set set = new HashSet<>(list);
        System.out.println(set.size());
    }
}
