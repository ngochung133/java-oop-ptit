import java.util.*;
class Product{
    protected String typecode;
    protected String name;
    protected long price1;
    protected long price2;
    public Product(String typecode, String name, long price1, long price2) {
        this.typecode = typecode;
        this.name = name;
        this.price1 = price1;
        this.price2 = price2;
    }
    public long getPriceType(char c){
        if(c == '1'){
            return price1;
        }
        return price2;
    }
}
class Invoice extends Product{
    private String full_id;
    private int quantity;
    private long discount;
    private long finalMoney;
    public Invoice(int order, String code, int quantity, Product p){
        super(p.typecode,p.name,p.price1,p.price2);
        this.full_id = code + String.format("-%03d",order);
        this.quantity = quantity;
        char productType = code.charAt(2);
        long Unitprice = super.getPriceType(productType);
        long total = Unitprice * quantity;
        this.discount = getDiscount(total);
        this.finalMoney = total - this.discount;
    }
    
    public String getFull_id() {
        return full_id;
    }

    public void setFull_id(String full_id) {
        this.full_id = full_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public long getFinalMoney() {
        return finalMoney;
    }

    public void setFinalMoney(long finalMoney) {
        this.finalMoney = finalMoney;
    }

    public long getDiscount(long total){
        if(this.quantity >= 150){
            return total * 50 / 100;
        }
        else if(this.quantity >= 100){
            return total * 30 / 100;
        }
        else if(this.quantity >= 50){
            return total * 15 / 100;
        }
        else{
            return 0;
        }
    }
}
public class j06001{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String , Product> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String typecode = sc.nextLine();
            String name = sc.nextLine();
            long price1 = Long.parseLong(sc.nextLine());
            long price2 = Long.parseLong(sc.nextLine());
            map.put(typecode, new Product(typecode,name,price1,price2));
        }
        int Q = Integer.parseInt(sc.nextLine());
        ArrayList<Invoice> arr = new ArrayList<>();
        for(int i = 1; i <= Q; i++){
            String []  a = sc.nextLine().trim().split("\\s+");
            String code = a[0];
            int quantity = Integer.parseInt(a[1]);
            String typeProduct = code.substring(0,2);
            Product p = map.get(typeProduct);
            arr.add(new Invoice(i,code,quantity,p));
        }
        for(Invoice in : arr){
            System.out.printf("%s %s %d %d%n",in.getFull_id(),in.name,in.getDiscount(),in.getFinalMoney());
        }
    }
}