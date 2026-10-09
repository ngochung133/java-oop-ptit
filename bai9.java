import java.util.Scanner;
    public class bai9{
        static long fibo(int n){
            long [] fibo = new long[93];
            fibo[1] = 1;
            fibo[2] = 1;
            for(int i = 3; i <= 92; i++){
                fibo[i] = fibo[i - 1] + fibo[i - 2];
            }
            return fibo[n];
        }
        public static void main(String [] args){
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            for(int i = 0; i < t; i++){
                int n = sc.nextInt();
                long x=  fibo(n);
                System.out.println(x);
            }
            sc.close();
        }
}
    