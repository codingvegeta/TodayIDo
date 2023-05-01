package programmers.level0.test1_50;

//옹알이
public class Test1 {
    public static String[] baby = new String[]{"aya", "ye", "woo", "ma"};
    public static int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < baby.length; j++) {
                if (babbling[i].contains(baby[j])) {
                    babbling[i] = babbling[i].replace(baby[j], "1");
                }
            }
        }
        for (int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("1", "");
        }
        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].equals("")) {
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] babbling = new String[]{"aya", "yee", "u", "maa", "wyeoo"};
        String[] babbling2 = new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        System.out.println(solution(babbling));
        System.out.println(solution(babbling2));

    }
}
