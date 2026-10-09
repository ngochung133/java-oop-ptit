import java.util.*;
public class j02037{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- >0){
            String s = sc.nextLine();
            String [] a = s.split("\\s+");
            boolean ok = true;
            int even = 0;
            int odd = 0;
            int [] b = new int[a.length];
            for(int i = 0; i < a.length;i++){
                b[i] = Integer.parseInt(a[i]);
            }
            for(int x : b){
                if(x % 2 ==0){
                    even++;
                }
                else{
                    odd++;
                }
            }
            if(b.length % 2 == 0){
                if(odd > even){
                    ok = false;
                }
            }
            else{
                if(even > odd){
                    ok = false;
                }
            }
            if(ok){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}