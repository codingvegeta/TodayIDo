package programmers.level0.test101_150;

import java.math.BigInteger;

//두 수의 합
public class Test129 {
    public static String solution(String a, String b) {
        String answer = "";
        System.out.println(BigInteger.valueOf(Long.valueOf(a)));
//        answer = String.valueOf().add(BigInteger.valueOf(Long.parseLong(b))));
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("18446744073709551615", "287346502836570928366"));
    }
}
