package beakjoon.solved.level1;


import java.util.Scanner;

public class Main2577 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];

        for (int i = 0; i < 3; i++) {
            nums[i] = sc.nextInt();
        }

    int A = nums[0];
    int B = nums[1];
    int C = nums[2];

        int result = A * B * C;
        String str = String.valueOf(result);
        int[] numbers = new int[10];
        for (int i = 0; i <str.length() ; i++) {
            int tmp = str.charAt(i)-'0';
            numbers[tmp] += 1;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
