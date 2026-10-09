import java.util.*;
class Point{
    double x;
    double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    double distance(Point other){
        return Math.sqrt(Math.pow(this.x - other.x,2) + Math.pow(this.y - other.y,2));
    }
}
public class j04010{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double x3 = sc.nextDouble();
            double y3 = sc.nextDouble();
            Point a = new Point(x1,y1);
            Point b = new Point(x2,y2);
            Point c = new Point(x3,y3);
            double ab = a.distance(b);
            double ac = a.distance(c);
            double bc = b.distance(c);
            if(ab + ac <= bc || ab + bc <= ac || ac + bc <= ab){
                System.out.println("INVALID");
            }
            else{
                double area = 0.25 * Math.sqrt((ab + bc + ac) *(ab + bc - ac) *(bc + ac - ab) * (ac + ab - bc));
                double r = ab * ac * bc / (4 * area);
                double s = r * r * Math.PI;
                System.out.printf("%.3f%n", s);
            }
        }
        sc.close();
    }   
}