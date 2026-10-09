import java.util.*;
public class Rectangle{
    int width;
    int height;
    String color;
    public Rectangle(){
        this.width = 1;
        this.height = 1;
    }
    public Rectangle(int width, int height, String color){
        this.width = width;
        this.height = height;
        this.color = color;
    }
    String chuanhoa(){
        this.color = this.color.toLowerCase();
        this.color = this.color.substring(0,1).toUpperCase() + this.color.substring(1);
        return this.color;
    }
    boolean check(){
        int a = (int) this.height;
        int b = (int) this.width;
        if(a <= 0 || b <= 0){
            return false;
        }
        return true;
    }
    int area(){
        return this.width * this.height;
    }
    int Perimeter(){
        return (this.width + this.height)*2;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        String color = sc.next();
        Rectangle hcn = new Rectangle(height,width,color);
        if(hcn.check()){
            System.out.println(hcn.Perimeter() + " " + hcn.area() + " " + hcn.chuanhoa());
        }
        else{
            System.out.println("INVALID");
        }
    }
}