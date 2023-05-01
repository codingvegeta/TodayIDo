package programmers.level0.test51_100;

public class Test53 {
    static public int solution(String binomial) {
        String[] s = binomial.split(" ");
        if (s[1].equals("+")) {
            return Integer.parseInt(s[0]) + Integer.parseInt(s[2]);
        } else if (s[1].equals("-")) {
            return Integer.parseInt(s[0]) - Integer.parseInt(s[2]);
        } else {
            return Integer.parseInt(s[0]) * Integer.parseInt(s[2]);
        }
    }
}
