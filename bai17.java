import java.util.*;
    public class bai17{
        static boolean [] prime;
        static void sang(int n){
            prime = new boolean[n + 1];
            Arrays.fill(prime, true);
            prime[0] = false;
            prime[1] = false;
            for(int i = 2; i <= Math.sqrt(n);i++){
                if(prime[i]){
                    for(int j = i * i; j <= n; j+=i){
                        prime[j] = false;
                    }
                }
            }
        }
        public static void main(String [] args){
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            sang(10000000);
            while(t-- >0){
                long n = sc.nextLong();
                long max = 0;
                for(int k = 2; k <= Math.sqrt(n); k++){
                    while(n % k == 0 && prime[k]){
                        max = Math.max(max,k);
                        n /= k;
                    }
                }
                if(n > 1){
                    max = n;
                }
                System.out.println(max);
            }
        }
    }