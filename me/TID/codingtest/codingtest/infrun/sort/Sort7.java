package infrun.sort;

import java.util.*;

class Point implements Comparable<Point> {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        } else {
        return this.x - o.x;
        }
    }

}

public class Sort7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> p = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            p.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(p);
        for (Point x :  p) {
            System.out.println(x.x + " " + x.y);
        }
    }
}
