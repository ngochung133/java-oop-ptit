import java.util.*;

class Point {

    long tu;

    long mau;

    public Point(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }

    void sum(Point other) {

        this.tu = this.tu * other.mau + other.tu * this.mau;

        this.mau = this.mau * other.mau;
    }

    void rutgon() {

        long a = this.tu;

        long b = this.mau;

        while (b != 0) {

            long r = a % b;

            a = b;

            b = r;
        }

        this.tu /= a;

        this.mau /= a;
    }

    static Point tich(Point a, Point b, Point c) {

        a.tu = a.tu * b.tu * c.tu;

        a.mau = a.mau * b.mau * c.mau;

        return new Point(a.tu, a.mau);
    }
}

public class j04014 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            Point p1 = new Point(sc.nextLong(), sc.nextLong());

            Point p2 = new Point(sc.nextLong(), sc.nextLong());

            Point res = new Point(p1.tu, p1.mau);

            p1.sum(p2);

            Point c = new Point(
                p1.tu * p1.tu,
                p1.mau * p1.mau
            );

            c.rutgon();

            Point d = Point.tich(res, p2, c);

            d.rutgon();

            System.out.printf(
                c.tu + "/" + c.mau + " "
                + d.tu + "/" + d.mau
            );

            System.out.println();
        }
    }
}