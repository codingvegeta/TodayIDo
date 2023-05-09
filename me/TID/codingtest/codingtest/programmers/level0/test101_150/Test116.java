package programmers.level0.test101_150;
// 문자열이 몇 번 등장하는지 세기
public class Test116 {
    public int solution(String myString, String pat) {
        int answer = 0;
        for(int i=0; i+pat.length() <= myString.length(); i++){
            String str = myString.substring(i,i+pat.length());
            if(str.equals(pat)){
                answer++;
            }
        }
        return answer;
    }
}
