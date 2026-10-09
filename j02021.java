import java.util.*;
public class j02021{
    static int n,k;
    static int [] a;
    static int cnt = 0;
    static void Try(int pos, int start){
        if(pos == k){
            for(int i = 0; i < k; i ++){
                System.out.print(a[i]);
            }
            System.out.print(" ");
            cnt++;
            return;
        }
        for(int i = start; i <= n; i++){
            a[pos] = i;
            Try(pos + 1, i + 1);
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[k];
        Try(0,1);
        System.out.println();
        System.out.println("Tong cong co " + cnt + " to hop");
    }
}