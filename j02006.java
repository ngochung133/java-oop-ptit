import java.util.*;
public class j02006{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> s = new TreeSet <>();
        int [] a = new int[n];
        int [] b = new int[m];
        for(int i = 0; i < n;i++){
            a[i] = sc.nextInt();
            s.add(a[i]);
        }
        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
            s.add(b[i]);
        }
        for(int x  : s){
            System.out.print(x + " ");
        }
        System.out.println();
        sc.close();
    }
}