// import java.util.*;
// class Point{
//     double x;
//     double y;
//     public Point(double x, double y){
//         this.x = x;
//         this.y = y;
//     }
//     double distance(Point other){
//         return Math.sqrt(Math.pow(this.x - other.x,2) + Math.pow(this.y - other.y,2));
//     }
// }
// public class j04009{
//     public static void main(String [] args){
//         Scanner sc = new Scanner(System.in);
//         int t = sc.nextInt();
//         while(t-- >0){
//             double x1 = sc.nextDouble();
//             double y1 = sc.nextDouble();
//             double x2 = sc.nextDouble();
//             double y2 = sc.nextDouble();
//             double x3 = sc.nextDouble();
//             double y3 = sc.nextDouble();
//             Point a = new Point(x1,y1);
//             Point b = new Point(x2,y2);
//             Point c = new Point(x3,y3);
//             double ab = a.distance(b);
//             double ac = a.distance(c);
//             double bc = b.distance(c);
//             if(ab + ac <= bc || ab + bc <= ac || ac + bc <= ab){
//                 System.out.println("INVALID");
//             }
//             else{
//                 double area = 0.25 * Math.sqrt((ab + bc + ac) *(ab + bc - ac) *(bc + ac - ab) * (ac + ab - bc));
//                 System.out.printf("%.2f%n", area);
//             }
//         }
//         sc.close();
//     }   
// }
import java.io.InputStream;
import java.util.*;

public class j04009 {
    
    
    static class Point{
        double x, y;
        
        public Point(double a, double b){
            x = a;
            y = b;
        }

        static Point nextPoint(Scanner sc){
            Point a = new Point(sc.nextDouble(), sc.nextDouble());
            return a;
        }
    }
    
    static double dis(Point a, Point b){
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    static class Triangle{
        double A, B, C;
        public Triangle(Point a, Point b, Point c){
            A = dis(a, b);
            B = dis(b, c);
            C = dis(c, a);
        }
        public boolean valid(){
            double m = Math.max(A, Math.max(B, C));
            return 2*m < A + B + C;
        }
        public String getPerimeter(){
            double s = Math.sqrt((A+B+C)*(A+B-C)*(A-B+C)*(-A+B+C))/4;
            return String.format("%.2f", s);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}