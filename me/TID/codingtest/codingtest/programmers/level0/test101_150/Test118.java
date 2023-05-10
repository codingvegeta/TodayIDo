package programmers.level0.test101_150;

public class Test118 {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        for(int i = 0; i<dic.length; i++){
            String str = dic[i];
            int count = 0;
            for(int j =0; j<spell.length; j++){
                if(str.contains(spell[j])){
                    count++;
                }
            }
            if(count == spell.length){
                answer++;
            }
        }
        if(answer > 0){
            return 1;
        }else{
            return 2;
        }
    }
}
