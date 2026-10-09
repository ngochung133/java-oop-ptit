import java.util.*;
public class j03007{
    static String nghich(String s){
        return new StringBuilder(s).reverse().toString();
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            boolean ok = true;
            String rev = nghich(s);
            if(!rev.equals(s)){
                ok = false;
            }
            else{
                if(s.charAt(0) != '8' && s.charAt(s.length() - 1) != '8'){
                    ok = false;
                }
                else{
                    long sum = 0;
                    for(int i = 0; i < s.length(); i++){
                        int x = s.charAt(i) - '0';
                        sum += x;
                    }
                    if(sum % 10 != 0){
                        ok = false;
                    }
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