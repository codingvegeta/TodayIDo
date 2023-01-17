package algorithm.book.chapter3;

public class Q4 {
    static int binSearchX(int[] a, int n, int key) {
        int start = 0;
        int end = n;
        while (start < end) {
            int middleNumber = (start + end) / 2;
            if (a[middleNumber] == key) {
                for (; middleNumber > start; middleNumber--) {
                    if (a[middleNumber - 1] < key) {
                        break;
                    }
                }
                return middleNumber;
            } else if (a[middleNumber] < key) {
                start = middleNumber + 1;
            } else {
                end = middleNumber - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 11;
        int[] a = {1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};
        int key = 7;
        System.out.println(binSearchX(a, n, key));

    }
}
