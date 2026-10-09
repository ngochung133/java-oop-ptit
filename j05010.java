import java.util.*;
class product{
    int id;
    String name;
    String type;
    double buy;
    double sell;
    public product(){
        id = 0;
        name = "";
        type = "";
        buy = 0;
        sell = 0;
    }
    double profit(){
        return sell - buy;
    }
}
public class j05010{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        product [] a = new product[n];
        for(int i = 0; i < n; i++){
            product pro = new product();
            pro.id = i + 1;
            pro.name = sc.nextLine();
            pro.type = sc.nextLine();
            pro.buy = Double.parseDouble(sc.nextLine());
            pro.sell = Double.parseDouble(sc.nextLine());
            a[i] = pro;
        }
        Arrays.sort(a, new Comparator<product>(){
            public int compare(product a, product b){
                return Double.compare(b.profit(),a.profit());
            }
        });
        for(product pro : a){
            System.out.printf("%d %s %s %.2f%n",pro.id,pro.name,pro.type,pro.profit());
        }
    }
}