import java.util.*;
public class j03009{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- >0){
            String s1 = sc.nextLine();
            String s2= sc.nextLine();
            Set<String> set1 = new TreeSet <>();
            String [] a = s1.split("\\s+");
            String [] b = s2.split("\\s+");
            Set<String> set2 = new TreeSet <>();
            for(String x : a){
                set1.add(x);
            }
            for(String x : b){
                set2.add(x);
            }
            for(String x : set1){
                if(!set2.contains(x)){
                    System.out.print(x + " ");
                }
            }
            System.out.println();
        }
    }
}