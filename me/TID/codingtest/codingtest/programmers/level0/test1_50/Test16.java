package programmers.level0.test1_50;
// 이어 붙인 수
public class Test16 {
    public int solution(int[] num_list) {
        String s1 = "";
        String s2 = "";
        for(int i = 0; i<num_list.length; i++){
            if (num_list[i] % 2 == 0){
                s1+= String.valueOf(num_list[i]);
            }else{
                s2+= String.valueOf(num_list[i]);
            }
        }
        return Integer.parseInt(s1)+Integer.parseInt(s2);
    }
}
