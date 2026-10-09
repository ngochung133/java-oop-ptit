import java.util.*;

class Point3D{
    int x;
    int y;
    int z;
    public Point3D(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    static boolean check(Point3D p1, Point3D p2, Point3D p3, Point3D p4){
        int ABx = p2.x - p1.x;
        int ABy = p2.y - p1.y;
        int ABz = p2.z - p1.z;
        int ACx = p3.x - p1.x;
        int ACy = p3.y - p1.y;
        int ACz = p3.z - p1.z;
        int ADx = p4.x - p1.x;
        int ADy = p4.y - p1.y;
        int ADz = p4.z - p1.z;
        long result =  (long) ABx * (ACy * ADz - ACz * ADy)
              - (long) ABy * (ACx * ADz - ACz * ADx)
              + (long) ABz * (ACx * ADy - ACy * ADx);
        if(result != 0){
            return false;
        }
        return true;
    }
}
public class j04011{
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        Point3D p1 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p2 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p3 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p4 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        
        if(Point3D.check(p1,p2,p3,p4)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
        }
    }
}