package programmers.level0;

// 외계행성의 나이
public class Test43 {
    static public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        while (age > 0) {
            char x = (char)('a' + (char) (age % 10));
            sb.append(x);
            age /= 10;
        }
        return sb.reverse().toString();
    }
}
