import java.util.*;
class Corp{
    private String id;
    private String name;
    private int quantity;
    public Corp(String id,String name,int quantity){
        this.id = id;
        this.name=  name;
        this.quantity = quantity;
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
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
public class j05029{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Corp> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String id = sc.nextLine();
            String name = sc.nextLine();
            int quantity = Integer.parseInt(sc.nextLine());
            map.put(id, new Corp(id,name,quantity));
        }
        int Q = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < Q; i++){
            String [] querry = sc.nextLine().trim().split("\\s+");
            int a = Integer.parseInt(querry[0]);
            int b = Integer.parseInt(querry[1]);
            ArrayList<Corp> arr = new ArrayList<>();
        for(Corp c : map.values()){
            if(c.getQuantity() >= a && c.getQuantity() <= b){
                arr.add(c);
            }
        }
        arr.sort(new Comparator<Corp>(){
            public int compare(Corp a, Corp b){
                if(a.getQuantity() == b.getQuantity()){
                    return a.getId().compareTo(b.getId());
                }
                return Integer.compare(b.getQuantity(),a.getQuantity());
            }
        });
        System.out.println("DANH SACH DOANH NGHIEP NHAN TU " + a + " DEN " + b + " SINH VIEN:");
        for(Corp c : arr){
            System.out.printf("%s %s %d%n",c.getId(),c.getName(),c.getQuantity());
        }
        }
    }
}