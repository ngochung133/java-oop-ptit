import java.util.*;
public class j02027{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int [] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            int cnt = 0;
            Arrays.sort(a);
            for(int i = 0; i < n - 1; i++){
                for(int j = i + 1; j < n; j++){
                    if(Math.abs(a[j] - a[i]) < k){
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}