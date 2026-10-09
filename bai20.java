import java.util.*;
public class bai20{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-- > 0){
                String s = sc.next();
                long sum  = 0;
                for(int i = 0; i < s.length(); i++){
                    int a = s.charAt(i) - '0';
                    sum +=a;
                }
                boolean ok = true;
                if(sum % 10 != 0){
                    ok = false;
                }
                else{
                    for(int i = 1; i < s.length(); i++){
                        int a = s.charAt(i) - '0';
                        int b = s.charAt(i - 1) - '0';
                        if(Math.abs(a - b) != 2){
                            ok = false;
                            break;
                        }
                    }
                }
                if(ok){
                    System.out.print("YES");
                }
                else{
                    System.out.print("NO");
                }
                System.out.println();
            }
        }
    }
