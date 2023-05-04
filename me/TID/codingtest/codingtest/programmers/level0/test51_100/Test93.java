package programmers.level0.test51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 문자열 잘라서 정렬하기
public class Test93 {
    static public  ArrayList<String> solution(String myString) {
        ArrayList<String> answer = new ArrayList<>();
        String[] split = myString.replace('x', ' ').split(" ");
        for(int i=0; i< split.length; i++){
            if(!split[i].isBlank()){
                answer.add(split[i]);
            }
        }
        Collections.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("axbxcxdx"));
        System.out.println(solution("dxccxbbbxaaaa"));
        System.out.println(solution("dxccxbbbxxaaaa"));

    }
}
