import java.util.*;
class Customer{
    private String id;
    private long old_index;
    private long new_index;
    private String SD;
    private int HeSo;
    private long Money;
    private long PhuTroi;
    private long Total;
    public Customer(String SD,int order, long old_index,long new_index){
        this.id = String.format("KH%02d",order);
        this.old_index = old_index;
        this.new_index = new_index;
        this.SD = SD;
        this.HeSo = cal_HeSo();
        this.Money = (new_index - old_index) * this.HeSo * 550;
        this.PhuTroi = cal_PhuTroi();
        this.Total = this.Money + this.PhuTroi;
    }
    public int cal_HeSo(){
        if(SD.equals("KD")){
            return 3;
        }
        else if(SD.equals("NN")){
            return 5;
        }
        else if(SD.equals("TT")){
            return 4;
        }
        else{
            return 2;
        }
    }
    public long cal_PhuTroi(){
        long temp = this.new_index - this.old_index;
        if(temp < 50){
            return 0;
        }
        else if(temp <= 100){
            return Math.round(this.Money * 35 / 100.0);
        }
        else{
            return this.Money;
        }
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public long getOld_index() {
        return old_index;
    }
    public void setOld_index(long old_index) {
        this.old_index = old_index;
    }
    public long getNew_index() {
        return new_index;
    }
    public void setNew_index(long new_index) {
        this.new_index = new_index;
    }
    public String getSD() {
        return SD;
    }
    public void setSD(String sD) {
        SD = sD;
    }
    public int getHeSo() {
        return HeSo;
    }
    public void setHeSo(int heSo) {
        HeSo = heSo;
    }
    public long getMoney() {
        return Money;
    }
    public void setMoney(long money) {
        Money = money;
    }
    public long getPhuTroi() {
        return PhuTroi;
    }
    public void setPhuTroi(long phuTroi) {
        PhuTroi = phuTroi;
    }
    public long getTotal() {
        return Total;
    }
    public void setTotal(long total) {
        Total = total;
    }
    
}
public class j05051{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Customer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String SD = sc.nextLine();
            long old_index = Long.parseLong(sc.nextLine());
            long new_index = Long.parseLong(sc.nextLine());
            arr.add(new Customer(SD,i,old_index,new_index));
        }
        arr.sort(new Comparator<Customer>(){
            public int compare(Customer a, Customer b){
                return Long.compare(b.getTotal(),a.getTotal());
            }
        });
        for(Customer c : arr){
            System.out.printf("%s %d %d %d %d%n",c.getId(),c.getHeSo(),c.getMoney(),c.getPhuTroi(),c.getTotal());
        }
    }
}