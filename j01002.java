import java.util.*;
public class j01002{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        long [] len = new long[93];
        len[1] = 1;
        len[2] = 1;
        for(int i = 3; i < 93;i++){
            len[i] = len[i-2] + len[i-1];
        }
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            long k = sc.nextLong();
            while(n > 2){
                if(k <= len[n - 2]){
                    n = n - 2;
                }
                else{
                    k = k - len[n-2];
                    n = n - 1;
                }
            }
            if(n == 1){
                System.out.println("0");
            }
            else{
                System.out.println("1");
            }
        }
    }
}