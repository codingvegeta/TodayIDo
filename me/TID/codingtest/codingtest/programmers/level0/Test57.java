package programmers.level0;

import java.util.ArrayList;
import java.util.Arrays;

public class Test57 {
    public ArrayList<String> solution(String my_string) {
        String[] answer = {};
        boolean flag = false;
        ArrayList<String> list = new ArrayList<>();
        String str = "";
        for(char x : my_string.toCharArray()){
            if(Character.isAlphabetic(x)){
                flag = true;
                if(flag){
                    str+=x;
                }
            }else{
                if(flag){
                    list.add(str);
                    str = "";
                }
                flag = false;
            }
        }
        if(!str.equals("")){
            list.add(str);
        }
        return list;
    }
    static public String[] solution2(String my_string) {
        return my_string.trim().split("[ ]+");
    }

}
