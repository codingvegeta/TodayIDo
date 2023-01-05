package algorithm.book.chapter2.question;

public class CardConv {
    static int cardConv(int x, int r, char[] d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            System.out.println(r + "|       " + x + "..." + x % r);
            System.out.println(" +---------");
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);
        System.out.println("       " + x );
        for (int i = 0; i < digits / 2; i++) {
            char t = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = t;
        }

        return digits;
    }
}
