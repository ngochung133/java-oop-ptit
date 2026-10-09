import java.util.*;
public class j02016{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int [n];
        int count = 0;
        for(int i = 0; i < n; i++){
            int cnt0 = 0;
            int cnt1 = 0;
            for(int j = 0; j < 3; j++){
                a[i] = sc.nextInt();
                if(a[i] == 0){
                    cnt0++;
                }
                else{
                    cnt1++;
                }
            }
            if(cnt1 > cnt0){
                count++;
            }
        }
        System.out.println(count);
    }
}