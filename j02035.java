import java.util.*;
public class j02035{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int [] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            int k  = 0;
            for(int i = 0; i < n - 1; i++){
                if(a[i] > a[i + 1]){
                    k = i + 1;
                    break;
                }
            }
            System.out.println(k);
        } 
    }
}