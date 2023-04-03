package programmers.level0;

// 다음에 올 숫자
public class Test2 {
    public static int solution(int[] common) {
        int answer = 0;
        if (common[1] - common[0] == common[2] - common[1]) {
            answer = common[common.length - 1] + (common[1] - common[0]);
        }else
            answer = common[common.length - 1] * (common[1] / common[0]);
        return answer;
    }

    public static void main(String[] args) {
        int[] common1 = new int[]{1, 2, 3, 4};
        int[] common2 = new int[]{2, 4, 8};
        int[] common3 = new int[]{-2, -4, -8};
        int[] common4 = new int[]{-8, -4, -2};
        System.out.println(Math.abs(4 * -4));
        System.out.println(solution(common1));
        System.out.println(solution(common2));
        System.out.println(solution(common3));
        System.out.println(solution(common4));
    }
}
