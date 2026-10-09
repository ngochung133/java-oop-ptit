import java.util.Scanner;
public class main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a <= 0 || b <=0){
            System.out.println(0);
        }
        else{
            int chu_vi = (a + b) * 2;
            int dien_tich = a * b;
            System.out.println(chu_vi + " " + dien_tich);
        }
        sc.close();
    }
}