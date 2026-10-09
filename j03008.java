import java.util.*;
public class j03008{
    static String nghich(String s){
        return new StringBuilder(s).reverse().toString();
    }
    static boolean prime(int n){
        boolean [] prime = new boolean[11];
        Arrays.fill(prime,true);
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i < Math.sqrt(n);i++){
            if(prime[i]){
                for(int j = i * i; j <= n; j+=i){
                    prime[j] = false;
                }
            }
        }
        return prime[n];
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            String s = sc.next();
            boolean ok = true;
            String rev = nghich(s);
            if(!s.equals(rev)){
                ok = false;
            }
            else{

                for(int i = 0; i < s.length();i++){
                    int x = s.charAt(i) - '0';
                    if(!prime(x)){
                        ok = false;
                    }
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