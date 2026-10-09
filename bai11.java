import java.util.*;
public class bai11{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int test = 1; test <= t; test++){
            long n = sc.nextLong();
            System.out.print("Test " + test + ": ");
            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                    int count = 0;
                    while(n % i == 0){
                        count++;
                        n /= i;
                    }
                    System.out.print(i + "(" + count + ") ");
                }
            }
            if(n > 1){
                System.out.print(n + "(" + 1 + ") ");
            }
            System.out.println();
        }
    }
}