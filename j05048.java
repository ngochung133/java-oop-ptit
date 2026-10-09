import java.util.*;
class Product{
    private String id;
    private long nhap;
    private long xuat;
    private long gia;
    private long tax;
    private long total;
    public Product(String id,long nhap){
        this.id = id;
        this.nhap = nhap;
        this.xuat = cal_xuat();
        this.gia = cal_gia();
        this.total = this.xuat * this.gia;
        this.tax = cal_tax();
    }
    public long cal_xuat(){
        if(this.id.charAt(0) == 'A'){
            return Math.round(this.nhap * 60 / 100.0);
        }
        else{
            return Math.round(this.nhap * 70 / 100.0);
        }
    }
    public long cal_gia(){
        char temp = this.id.charAt(this.id.length() - 1);
        if(temp == 'Y'){
            return 110000;
        }
        else {
            return  135000;
        }
    }
    public long cal_tax(){
        char st = this.id.charAt(0);
        char la = this.id.charAt(this.id.length() - 1);
        if(st == 'A' && la == 'Y'){
            return Math.round(this.total * 8.0 / 100);
        }
        else if(st == 'A' && la == 'N'){
            return (long) (this.total * 11.0 / 100);
        }
        else if(st == 'B' && la == 'Y'){
            return (long) (this.total * 17.0 / 100);
        }
        else{
            return (long) (this.total * 22.0 / 100);
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
    public long getGia() {
        return gia;
    }
    public void setGia(long gia) {
        this.gia = gia;
    }
    public long getTax() {
        return tax;
    }
    public void setTax(long tax) {
        this.tax = tax;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    
}
public class j05048{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Product> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.nextLine();
            long xuat = Long.parseLong(sc.nextLine());
            arr.add(new Product(id,xuat));
        }
        for(Product p : arr){
            System.out.printf("%s %d %d %d %d %d%n", p.getId(),p.getNhap(),p.getXuat(),p.getGia(),p.getTotal(),p.getTax());
        }
    }
}