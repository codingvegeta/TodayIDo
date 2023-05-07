package programmers.level0.test101_150;
// 글자 지우기
public class Test110 {
    static String solution(String my_string, int[] indices) {
        char[] d = my_string.toCharArray();
        for(int i =0; i< indices.length; i++){
            d[indices[i]]='1';
        }
        return  String.valueOf(d).replaceAll("1", "");
    }
}
