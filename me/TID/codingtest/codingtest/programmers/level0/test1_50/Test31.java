package programmers.level0.test1_50;

// 꼬리 문자열
public class Test31 {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        for(int i=0; i< str_list.length; i++){
            if(!str_list[i].contains(ex)){
                answer+=str_list[i];
            }
        }
        return answer;
    }
}
