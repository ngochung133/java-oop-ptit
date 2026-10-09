import java.util.*;
public class bai14{
    static long ucln(long a,long b){
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    static long bcnn(long a, long b){
        return a / ucln(a,b) * b;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            System.out.println(bcnn(a,b) + " " + ucln(a,b));
        }
    }
}