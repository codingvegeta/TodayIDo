package programmers.level0.test1_50;

public class Test44 {
    static int solution(String myString, String pat) {
        myString = myString.replaceAll("A", "C").replaceAll("B", "A").replaceAll("C", "B");
        return myString.contains(pat) ? 1 : 0;
    }

}
