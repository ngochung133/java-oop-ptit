import java.util.*;
public class bai16{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int [] a = new int[t];
        int max = 0;
        for(int i = 0; i < t; i++){
            a[i] = sc.nextInt();
            max = Math.max(max,a[i]);
        }
        int [] prime = new int[max + 1];
        Arrays.fill(prime,1);
        prime[0] = 0;
        prime[1] = 0;
        for(int j = 2;j <= Math.sqrt(max);j++){
            if(prime[j] == 1){
                for(int p = j * j; p <= max; p += j){
                    prime[p] = 0;
                }
            }
        }
        long sum = 0;
        for(int x : a){
            for(int k = 2; k <= Math.sqrt(x); k++){
                if(prime[k] == 1){
                    while(x % k ==0){
                        sum += k;
                        x /= k;
                    }
                }
            }
            if(x > 1){
                sum += x;
            }
        }
        System.out.println(sum);
        sc.close();
    }
}