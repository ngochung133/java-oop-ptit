import java.util.*;
class Product{
    protected String TypeCode;
    protected String name;
    protected long price1;
    protected long price2;
    public Product(String TypeCode, String name,long price1,long price2){
        this.TypeCode = TypeCode;
        this.name = name = name;
        this.price1 = price1;
        this.price2 = price2;
    }
    public long getTypePrice(char c){
        if(c == '1'){
            return this.price1;
        }
        else{
            return this.price2;
        }
    }
}
class Invoice extends Product{
    private String full_id;
    private int quantity;
    private long discount;
    private long finalMoney;
    public Invoice(int order, String code,int quantity,Product P){
        super(P.TypeCode,P.name,P.price1,P.price2);
        this.quantity = quantity;
        this.full_id = code + String.format("-%03d",order);
        char c = code.charAt(2);
        long Unitprice = super.getTypePrice(c);
        long total = Unitprice * quantity;
        this.discount = getDiscount(total,quantity);
        this.finalMoney = total - this.discount;
    }
    public long getDiscount(long total, int q){
        if(q >= 150){
            return total * 50 / 100;
        }
        else if(q >= 100){
            return total * 30 / 100;
         }
        else if(q >= 50){
            return total * 15 / 100;
        }
        else return 0;
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
    
}
public class j06002{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Product> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String TypeCode = sc.nextLine();
            String name = sc.nextLine();
            long price1 = Long.parseLong(sc.nextLine());
            long price2 = Long.parseLong(sc.nextLine());
            map.put(TypeCode, new Product(TypeCode,name,price1, price2));
        }
        int Q = Integer.parseInt(sc.nextLine());
        ArrayList<Invoice> arr = new ArrayList<>();
        for(int i = 1; i <= Q; i++){
            String [] infor = sc.nextLine().trim().split("\\s+");
            String code = infor[0];
            int quantity = Integer.parseInt(infor[1]);
            String querry = code.substring(0,2);
            Product p = map.get(querry);
            arr.add(new Invoice(i,code,quantity,p));
        }
        arr.sort(new Comparator<Invoice>(){
            public int compare(Invoice a, Invoice b){
                return Long.compare(b.getFinalMoney(),a.getFinalMoney());
            }
        });
        for(Invoice in : arr){
            System.out.printf("%s %s %d %d%n",in.getFull_id(),in.name,in.getDiscount(),in.getFinalMoney());
        }
    }
}