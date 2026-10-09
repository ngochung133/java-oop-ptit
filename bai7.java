import java.util.Scanner;
public class bai7{
    static int prime(long n){
        if (n < 2){
            return 0;
        }
        else{
            for(int i = 2; i <= Math.sqrt(n); i++){
                if (n % i == 0){
                    return 0;
                }
            }
        }
        return 1;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            long n = sc.nextLong();
            if(prime(n) == 1){
            System.out.println("YES");
        }
            else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}