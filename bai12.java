import java.util.*;
public class bai12{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        long gt = 1;
        int i = 1;
        while(i <= n){
            gt *= i;
            sum += gt;
            i++;
        }    
        System.out.println(sum);    
    }
}