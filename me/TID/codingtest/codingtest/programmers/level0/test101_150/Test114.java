package programmers.level0.test101_150;

import java.util.Arrays;

// 특정 문자열로 끝나는 가장 긴 부분 문자열 찾기
public class Test114 {
    public String solution(String myString, String pat) {
        return myString.substring(0,myString.lastIndexOf(pat)+pat.length());
    }
}
