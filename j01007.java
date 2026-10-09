import java.util.*;
public class j01007{
    static long [] fibo(){
        long [] fib = new long[93];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i < 93; i++){
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            long n = sc.nextLong();
            long [] fib = fibo();
            boolean ok = false;
            for(int i = 0; i < 93; i++){
                if(fib[i] == n){
                    ok = true;
                    break;
                }
            }
            if(ok){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}