package programmers.level0.test1_50;

//접미사인지 확인하기

public class Test48 {
    public int solution(String my_string, String is_suffix) {
        int answer = 1;
        if(is_suffix.length() > my_string.length()){
            return 0;
        }
        int m = my_string.length() - is_suffix.length();
        int p = is_suffix.length() -1;
        for(int i =my_string.length() -1; i>=m; i--){
            if(my_string.charAt(i) != is_suffix.charAt(p--)){
                return 0;
            }
        }
        return answer;
    }

    public int solution2(String myString, String isSuffix) {
        return myString.endsWith(isSuffix) ? 1 : 0;
    }
}
