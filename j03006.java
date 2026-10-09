import java.util.*;
public class j03006{
    static String thuannghich (String s){
       return new StringBuilder(s).reverse().toString();
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            String s = sc.next();
            String rev = thuannghich(s);
            boolean ok = true;
            if(!s.equals(rev)){
                ok = false;
            }
            else{
                for(int i = 0; i < s.length();i++){
                    int x = s.charAt(i) - '0';
                    if(x % 2 != 0){
                        ok = false;
                        break;
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