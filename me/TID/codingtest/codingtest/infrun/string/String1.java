package infrun.string;

import java.util.Scanner;

public class String1 {
    public static int solution(String str, char a){
        int result = 0;

        for(char strs : str.toCharArray()){
            if(strs == a) result++;
        }

        return result;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next().toLowerCase();
        char input2 = in.next().toLowerCase().charAt(0);

        System.out.println(solution(input1, input2));
    }
}
