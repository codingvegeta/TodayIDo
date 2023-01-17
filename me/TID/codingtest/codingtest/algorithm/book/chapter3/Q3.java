package algorithm.book.chapter3;

public class Q3 {
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                idx[count++] = a[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 8;
        int[] a = {1, 9, 2, 9, 4, 6, 7, 9};
        int key = 9;
        int[] idx = new int[n];
        int i = searchIdx(a, n, key, idx);
        System.out.println("i = " + i);

    }
}
