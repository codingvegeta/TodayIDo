package programmers.level0.test51_100;
//k의 개수
public class Test77 {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String s1 = String.valueOf(k);
        for(int l = i; l<=j; l++){
            String s2 = String.valueOf(l);
            for(int a = 0; a<s2.length(); a++){
                if(s1.charAt(0) == s2.charAt(a)){
                    answer++;
                }
            }
        }
        return answer;
    }

    public int solution2(int i, int j, int k) {
        String str = "";
        for(int a = i; a <= j; a++) {
            str += a+"";
        }

        return str.length() - str.replace(k+"", "").length();
    }
}
