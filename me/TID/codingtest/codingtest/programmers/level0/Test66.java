package programmers.level0;

public class Test66 {
    static String solution(String letter) {
        String[] mose = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
                ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] s = letter.split(" ");
        String answer = "";
        for(int i =0; i< s.length; i++){
            for(int j=0; j < mose.length; j++){
                if (s[i].equals(mose[j])) {
                    answer += (char)('a' + j);
                }
            }
        }
        return answer;
    }
}
