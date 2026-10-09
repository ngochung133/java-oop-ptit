import java.util.*;
public class Point{
    double x;
    double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    double distance(Point p){
        return Math.sqrt(Math.pow(this.x - p.x,2) +  Math.pow(this.y - p.y,2));
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            Point p1 = new Point(x1,y1);
            Point p2 = new Point(x2,y2);
            System.out.printf("%.4f",p1.distance(p2));
            System.out.println();
        }
        sc.close();
    }
}