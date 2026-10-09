import java.util.*;

class Product {
    private String id;
    private long nhap;
    private long xuat;
    private long price;
    private long total;
    private long tax;
    public Product(String id,long nhap){
        this.id = id;
        this.nhap =nhap;
        this.xuat = cal_xuat();
        this.price = cal_price();
        this.total = this.xuat * this.price;
        this.tax = cal_tax();
    }
    public long cal_xuat(){
        char temp = this.id.charAt(0);;
        if(temp =='A'){
            return Math.round(nhap * 60 / 100.0);
        }
        else{
            return Math.round(this.nhap * 70 / 100.0);
        }
    }
    public long cal_price(){
        char temp = this.id.charAt(this.id.length() - 1);
        if(temp == 'Y'){
            return 110000;
        }
        else{
            return 135000;              
        }
    }
    public long  cal_tax(){
        char st = this.id.charAt(0);
        char la = this.id.charAt(this.id.length() - 1);
        if(st == 'A' && la == 'Y'){
            return Math.round(this.total * 8 / 100.0);
        }
        else if(st == 'A' && la == 'N'){
            return Math.round(this.total * 11 / 100.0);
        }
        else if(st == 'B' && la == 'Y'){
            return Math.round(this.total * 17 / 100.0);
        }
        else{
            return Math.round(this.total * 22 / 100.0);
        }
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public long getNhap() {
        return nhap;
    }
    public void setNhap(long nhap) {
        this.nhap = nhap;
    }
    public long getXuat() {
        return xuat;
    }
    public void setXuat(long xuat) {
        this.xuat = xuat;
    }
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public long getTax() {
        return tax;
    }
    public void setTax(long tax) {
        this.tax = tax;
    }
}
public class j05049{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String,ArrayList<Product>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String id = sc.nextLine();
            long nhap = Long.parseLong(sc.nextLine());
            String k = String.valueOf(id.charAt(0));
            if (!map.containsKey(k)) {
                map.put(k, new ArrayList<>());
            }
            map.get(k).add(new Product(id,nhap));
        }
        String querry = sc.nextLine().trim();
        if(map.containsKey(querry)){
            map.get(querry).sort(new Comparator<Product>(){
                public int compare(Product a, Product b){
                    return Long.compare(b.getTax(),a.getTax());
                }
            });
            for(Product p : map.get(querry)){
                System.out.printf("%s %d %d %d %d %d%n",p.getId(),p.getNhap(),p.getXuat(),p.getPrice(),p.getTotal(),p.getTax());
            }
        }
    }
}