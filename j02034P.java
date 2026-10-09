import java.util.*;
public class j02034P{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        int maxx = 0;
        Set<Integer> s = new TreeSet <> ();
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            s.add(a[i]);
        }
        Arrays.sort(a);
       int len = a[a.length - 1] - 1 + 1;
       if(len == n){
            System.out.println("Excellent!");
       }
       else{
            for(int i = 1; i <= a[a.length - 1]; i++){
                if(!s.contains(i)){
                    System.out.println(i);
                }
            }
       }
       sc.close();
    }
}