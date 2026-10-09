import java.util.*;
public class j02005{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] a = new int[n];
        int [] b = new int[m];
        Set<Integer> s = new TreeSet <>();
        Set<Integer> ans = new TreeSet <>();
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            s.add(a[i]);
        }
        for(int i = 0; i < m; i ++){
            b[i] = sc.nextInt();
        }
        for(int x : b){
            if(s.contains(x)){
                ans.add(x);
            }
        }
        for(int x : ans){
            System.out.print(x + " ");
        }
        System.out.println();
    }
}