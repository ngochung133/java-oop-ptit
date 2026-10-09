import java.util.*;
class category{
    String id;
    String name;
    int quantity;
    long cost;
    long trietkhau;
    public category(){
        id = "";
        name = "";
        quantity = 0;
        cost = 0;
        trietkhau = 0;
    }
    long money(){
        return quantity * cost - trietkhau;
    }
}
public class j05012{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        category [] a = new category[n];
        for(int i = 0; i < n; i++){
            category cat = new category();
            cat.id = sc.nextLine();
            cat.name = sc.nextLine();
            cat.quantity = Integer.parseInt(sc.nextLine());
            cat.cost = Long.parseLong(sc.nextLine());
            cat.trietkhau = Long.parseLong(sc.nextLine());
            a[i] = cat;
        }
        Arrays.sort(a, new Comparator<category>(){
            public int compare(category a, category b){
                return Long.compare(b.money(),a.money());
            }
        });
        for(category cat : a){
            System.out.printf("%s %s %d %d %d %d%n", cat.id,cat.name,cat.quantity,cat.cost,cat.trietkhau,cat.money());
        }
    }
}