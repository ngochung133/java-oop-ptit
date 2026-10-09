import java.util.*;

class Product{
    private String name;
    private String id;
    private long price;
    private long quantity;
    private long discount;
    private long total;
    private long last_total;
    public Product(String name,String id,long price,long quantity){
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.discount = cal_discount();
        this.total = this.price * this.quantity;
        this.last_total = this.total - this.discount;
    }
    public long cal_discount(){
        String c = String.valueOf(this.id.charAt(this.id.length() - 1));
        if(c.equals("1")){
            return Math.round(this.price * this.quantity * 50 / 100.0);
        }
        else{
            return Math.round(this.price * this.quantity * 30 / 100.0);
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public long getDiscount() {
        return discount;
    }
    public void setDiscount(long discount) {
        this.discount = discount;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public long getLast_total() {
        return last_total;
    }
    public void setLast_total(long last_total) {
        this.last_total = last_total;
    }
    public String stt(){
        return this.id.substring(1,4);
    }
}
public class j05053{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Product> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String name = sc.nextLine();
            String id= sc.nextLine();
            long price = Long.parseLong(sc.nextLine());
            long quantity = Long.parseLong(sc.nextLine());
            arr.add(new Product(name,id,price,quantity));
        }
        arr.sort(new Comparator<Product>(){
            public int compare(Product a, Product b){
                return a.stt().compareTo(b.stt());
            }
        });
        for(Product c : arr){
            System.out.printf("%s %s %s %d %d%n",c.getName(),c.getId(),c.stt(),c.getDiscount(),c.getLast_total());
        }
    }
}