package beakjoon.solved.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        String[] user_score = {"cheries2 200", "alex111 100", "coco 150", "puyo 120"};
        System.out.println(solution(3, user_score));
    }

    static int solution(int k, String[] user_score) {
        int answer = k;
        List<String> allUser = new ArrayList<>();
        List<Integer> allScore = new ArrayList<>();
        String[] boardUsername = new String[3];
        int[] boardScore = new int[3];

        for (int i = 0; i < user_score.length; i++) {
            String user = user_score[i];
            String[] usernameAndScore = user.split(" ");
            String username = usernameAndScore[0];
            allUser.add(username);
            int score = Integer.valueOf(usernameAndScore[1]);
            allScore.add(score);
        }
        for (int i = 0; i < 3; i++) {
            boardUsername[i] = allUser.get(i);
            boardScore[i] = allScore.get(i);
        }
        for (int i = 3; i < allScore.size(); i++) {
            int g = allScore.get(i);

            for (int j = 0; j < 3; j++) {
                if (g > boardScore[j]) {
                    int a = 0;
                    for (int l = 0; l < boardScore.length; l++) {
                        if (g > boardScore[l]) {
                            a++;
                        }
                    }
                    for (int l = 0; l < boardScore.length; l++) {
                        if (a > 1 && allUser.get(i).equals(boardUsername[l])) {
                            boardUsername[l] = allUser.get(i);
                            boardScore[l] = g;
                            break;
                        }
                    }
                    if (a > 1) {
                        boardScore[j] = g;
                        boardUsername[j] = allUser.get(i);
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
