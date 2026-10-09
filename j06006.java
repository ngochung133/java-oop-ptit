import java.util.*;

class Customer {
    private String id;
    private String name;
    private String sex;
    private String birth;
    private String addr;

    public Customer(int order, String name, String sex, String birth, String addr) {
        this.id = String.format("KH%03d", order);
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.addr = addr;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

class Product {
    private String id;
    private String name;
    private String unit;
    private int buy;
    private int sell;

    public Product(int order, String name, String unit, int buy, int sell) {
        this.id = String.format("MH%03d", order);
        this.name = name;
        this.unit = unit;
        this.buy = buy;
        this.sell = sell;
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

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }
}

class Invoice {
    private String id;
    private Customer cus;
    private Product pro;
    private long profit;
    private String cusId;
    private String proId;
    private int quantity;

    public Invoice(int order, Customer c, Product p, int quantity) {
        this.id = String.format("HD%03d", order);
        this.cus = c;
        this.pro = p;
        this.cusId = c.getId();
        this.proId = p.getId();
        this.quantity = quantity;
        this.profit = (long) (p.getSell() - p.getBuy()) * quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getC() {
        return cus;
    }

    public void setC(Customer c) {
        this.cus = c;
    }

    public Product getP() {
        return pro;
    }

    public void setP(Product p) {
        this.pro = p;
    }

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long total() {
        return (long) this.quantity * this.getP().getSell();
    }
}

public class j06006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = Integer.parseInt(sc.nextLine().trim());
        HashMap<String, Customer> map_cus = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String cus_name = sc.nextLine().trim();
            String cus_sex = sc.nextLine().trim();
            String cus_birth = sc.nextLine().trim();
            String cus_add = sc.nextLine().trim();
            Customer c = new Customer(i, cus_name, cus_sex, cus_birth, cus_add);
            map_cus.put(c.getId(), c);
        }

        int m = Integer.parseInt(sc.nextLine().trim());
        HashMap<String, Product> map_pro = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            String pro_name = sc.nextLine().trim();
            String pro_unit = sc.nextLine().trim();
            int pro_buy = Integer.parseInt(sc.nextLine().trim());
            int pro_sell = Integer.parseInt(sc.nextLine().trim());
            Product pro = new Product(i, pro_name, pro_unit, pro_buy, pro_sell);
            map_pro.put(pro.getId(), pro);
        }

        ArrayList<Invoice> a = new ArrayList<>();
        int k = Integer.parseInt(sc.nextLine().trim());
        for (int i = 1; i <= k; i++) {
            String[] arr = sc.nextLine().trim().split("\\s+");
            String cusId = arr[0];
            String proId = arr[1];
            int quantity = Integer.parseInt(arr[2]);
            Customer cus = map_cus.get(cusId);
            Product pro = map_pro.get(proId);
            a.add(new Invoice(i, cus, pro, quantity));
        }

        a.sort(new Comparator<Invoice>() {
            public int compare(Invoice a, Invoice b) {
                return Long.compare(b.getProfit(), a.getProfit());
            }
        });

        for (Invoice in : a) {
            System.out.printf("%s %s %s %s %d %d %d%n",
                    in.getId(),
                    in.getC().getName(),
                    in.getC().getAddr(),
                    in.getP().getName(),
                    in.getQuantity(),
                    in.total(),
                    in.getProfit()
            );
        }
        sc.close();
    }
}