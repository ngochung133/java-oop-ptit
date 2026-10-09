import java.util.*;
public class Phanso{
    long tu;
    long mau;
    public Phanso(long tu,long mau){
        this.tu = tu;
        this.mau = mau;
    }
    long gcd(){
        long a = this.tu;
        long b = this.mau;
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    void solve(){
        long ucln = gcd();
        this.tu /= ucln;
        this.mau /= ucln;
        System.out.println(this.tu + "/" + this.mau);
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        Phanso p = new Phanso(a,b);
        p.solve();
    }
}