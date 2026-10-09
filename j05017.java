import java.util.*;

class customer {
    String id;
    private String name;
    private long old_index;
    private long new_index;

    public customer(String id, String name, long old_index, long new_index) {
        this.id = id;
        this.name = name;
        this.old_index = old_index;
        this.new_index = new_index;
    }

    public String getName() {
        return name;
    }

    public long getOld_index() {
        return old_index;
    }

    public long getNew_index() {
        return new_index;
    }

    // Sửa lại hàm tính tiền nước dùng Math.round() để làm tròn chuẩn xác
    long getMoney() {
        long temp = getNew_index() - getOld_index();
        double money = 0;
        
        if (temp <= 50) {
            long res = temp * 100;
            money = res * 1.02; // Phụ phí 2%
        } else if (temp <= 100) {
            long res = 50 * 100 + (temp - 50) * 150;
            money = res * 1.03; // Phụ phí 3%
        } else {
            long res = 50 * 100 + 50 * 150 + (temp - 100) * 200;
            money = res * 1.05; // Phụ phí 5%
        }
        
        return Math.round(money);
    }

    public String getId() {
        return id;
    }
}

public class j05017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        ArrayList<customer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String id = String.format("KH%02d", i + 1);
            String name = sc.nextLine();
            long old_index = Long.parseLong(sc.nextLine());
            long new_index = Long.parseLong(sc.nextLine());
            a.add(new customer(id, name, old_index, new_index));
        }

        // Sắp xếp giảm dần theo tổng tiền
        a.sort(new Comparator<customer>() {
            public int compare(customer x, customer y) {
                return Long.compare(y.getMoney(), x.getMoney());
            }
        });

        // In kết quả
        for (customer c : a) {
            System.out.printf("%s %s %d%n", c.getId(), c.getName(), c.getMoney());
        }
        
        sc.close();
    }
}