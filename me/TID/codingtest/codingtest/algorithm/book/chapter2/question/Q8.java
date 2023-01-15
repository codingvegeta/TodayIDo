package algorithm.book.chapter2.question;

public class Q8 {
    class YMD {
        int y;
        int m;
        int d;

        public YMD(int y, int m, int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getM() {
            return m;
        }

        public void setM(int m) {
            this.m = m;
        }

        public int getD() {
            return d;
        }

        public void setD(int d) {
            this.d = d;
        }

        public YMD after(int n) {
            //n일 뒤의 날짜를 반환
            setD(getD() + n);
            return this;
        }

        public YMD before(int n) {
            //n일 앞의 날짜를 반환
            setD(getD() - n);
            return this;
        }
    }
}
