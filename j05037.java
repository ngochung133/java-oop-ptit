import java.util.*;
class Product{
    private String id;
    private String name;
    private String unit;
    private long nhap;
    private int quantity;
    private long trans;
    private long thanhtien;
    private long giaban;
    public Product(int order,String name,String unit, long nhap,int quantity){
        this.id = String.format("MH%02d",order);
        this.name = name;
        this.unit = unit;
        this.nhap = nhap;
        this.quantity = quantity;
        this.trans = Math.round(nhap * quantity * 0.05);
        this.thanhtien = Math.round(nhap * quantity + this.trans);
        Double x = thanhtien * 1.02 / quantity;
        this.giaban = (long) (Math.ceil(x / 100) * 100);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public long getNhap() {
        return nhap;
    }
    public void setNhap(long nhap) {
        this.nhap = nhap;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public long getTrans() {
        return trans;
    }
    public void setTrans(long trans) {
        this.trans = trans;
    }
    public long getThanhtien() {
        return thanhtien;
    }
    public void setThanhtien(long thanhtien) {
        this.thanhtien = thanhtien;
    }
    public long getGiaban() {
        return giaban;
    }
    public void setGiaban(long giaban) {
        this.giaban = giaban;
    }
    
}
public class j05037{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Product> a = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String name =sc.nextLine();
            String unit = sc.nextLine();
            long nhap = Long.parseLong(sc.nextLine());
            int quantity = Integer.parseInt(sc.nextLine());
            a.add(new Product(i,name,unit,nhap,quantity));
        }
        a.sort(new Comparator<Product>(){
            public int compare(Product a, Product b){
                return Long.compare(b.getGiaban(), a.getGiaban());
            }
        });
        for(Product p : a){
            System.out.printf("%s %s %s %d %d %d%n", p.getId(),p.getName(),p.getUnit(),p.getTrans(),p.getThanhtien(),p.getGiaban());
        }
    }
}