import java.util.*;
public class pso{
    long tu;
    long mau;
    public pso(long tu, long mau){
        this.tu = tu;
        this.mau = mau;
    }
    void sum(pso other){
        this.tu = this.tu * other.mau + other.tu * this.mau;
        this.mau = this.mau * other.mau;
    }
    void solve(){
        long a = this.tu;
        long b = this.mau;
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        this.tu /= a;
        this.mau /= a;
        System.out.println(this.tu + "/" + this.mau);
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        long tu1 = sc.nextLong();
        long mau1 = sc.nextLong();
        long tu2 = sc.nextLong();
        long mau2 = sc.nextLong();
        pso p1 = new pso(tu1,mau1);
        pso p2 = new pso(tu2,mau2);
        p1.sum(p2);
        p1.solve();
    }
}