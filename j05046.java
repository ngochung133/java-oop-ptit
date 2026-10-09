import java.util.*;
class Product{
    String id;
    String name;
    long quantity;
    long cost;
    private long chietkhau;
    private long total;
    private long money;
    public Product(String id, String name,long quantity,long cost){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.total = cost * quantity;
        this.chietkhau = cal_chietkhau();
        this.money = this.total - this.chietkhau;
    }
    
    
    public long cal_chietkhau(){
        if(this.quantity > 10){
            return this.total * 5 / 100;
        }
        else if(this.quantity >= 8){
            return this.total * 2 / 100;
        }
        else if(this.quantity >= 5){
            return this.total * 1 / 100;
        }
        else{
            return 0;
        }
    }
}
public class j05046{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Product> arr = new ArrayList<>();
        for(int i = 1; i<= n; i++){
            String name = sc.nextLine();
            long quantity = Long.parseLong(sc.nextLine());
            long cost = Long.parseLong(sc.nextLine());
            String word = "";
            String [] a = name.trim().split("\\s+");
            word = (a[0].substring(0,1) + a[1].substring(0,1)).toUpperCase();
            int count = map.getOrDefault(word, 0) + 1;
            map.put(word, count);
            String id= String.format("%s%02d",word,count);
            arr.add(new Product(id,name,quantity,cost));
        }
        for(Product p : arr){
            System.out.printf("%s %s %d %d%n", p.getId(),p.getName(),p.cal_chietkhau(),p.getMoney());
        }
    }
}