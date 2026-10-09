import java.util.*;
class poi{
    double x;
    double y;
    public poi(double x,double y){
        this.x = x;
        this.y = y;
    }
    double distance(poi other){
        return Math.sqrt(Math.pow(this.x - other.x,2) + Math.pow(this.y - other.y,2));
    }
}
public class j04008{
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
            poi a = new poi(x1,y1);
            poi b = new poi(x2,y2);
            poi c = new poi(x3,y3);
            double ab = a.distance(b);
            double ac = a.distance(c);
            double bc = b.distance(c);
            if(ab + bc <= ac || ab + ac <= bc ||ac + bc <= ab){
                System.out.println("INVALID");
            }
            else{
                double perimeter = ab + ac + bc;
                System.out.printf("%.3f%n",perimeter);
            }
        }
    }
}
