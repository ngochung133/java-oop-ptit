import java.util.*;
public class j03026{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            String s1 = sc.next();
            String s2 = sc.next();
            Set<String> set1 = new HashSet <>();
            Set<String> set2 = new HashSet <>();
            for(int i = 0; i < s1.length();i++){
                String s = "";
                for(int j = i; j < s1.length();j++){
                    s+= s1.charAt(j);
                    set1.add(s);
                }
            }
            for(int i = 0; i < s2.length();i++){
                String s = "";
                for(int j = i; j < s2.length();j++){
                    s+= s2.charAt(j);
                    set2.add(s);
                }
            }
            int maxx = 0;
            boolean ok = false;
            for(String s : set1){
                if(!set2.contains(s)){
                    maxx = Math.max(maxx,s.length());
                    ok = true;
                }
            }
            for(String s : set2){
                if(!set1.contains(s)){
                    maxx = Math.max(maxx,s.length());
                    ok = true;
                }
            }
            if(ok){
                System.out.println(maxx);
            }
            else{
                System.out.println(-1);
            }
        }
    }
}