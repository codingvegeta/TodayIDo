package programmers.level0.test101_150;

// 영어가 싫어요
public class Test109 {
    public long solution(String numbers) {
        String[] d = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] dn = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String str = "";
        for (int i = 0; i < d.length; i++) {
            if (numbers.contains(d[i])) {
                numbers = numbers.replaceAll(d[i], dn[i]);
            }
        }
        return Long.parseLong(numbers);
    }
}
