package infrun.string;

import java.util.Scanner;

public class String2 {
    public static StringBuilder sb = new StringBuilder();
    public static String solution(String str){
        for(char strs : str.toCharArray()){
            if(strs - 'a' < 0){
                sb.append(Character.toLowerCase(strs));
            }else{
                sb.append(Character.toUpperCase(strs));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        System.out.println(solution(input1));
        return ;
    }
}
