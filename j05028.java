import java.util.*;
class Organization{
    private String code;
    private String name;
    private int quantity;
    public Organization(String code , String name, int q){
        this.code = code;
        this.name = name;
        this.quantity = q;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
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
public class j05028{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Organization> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String code = sc.nextLine();
            String name = sc.nextLine();
            int quantity = Integer.parseInt(sc.nextLine());
            a.add(new Organization(code,name,quantity));
        }
        a.sort(new Comparator<Organization>(){
            public int compare(Organization a, Organization b){
                if(a.getQuantity() == b.getQuantity()){
                    return a.getCode().compareTo(b.getCode());
                }
                return Integer.compare(b.getQuantity(),a.getQuantity());
            }
        });
        for(Organization o : a){
            System.out.printf("%s %s %s%n", o.getCode(),o.getName(),o.getQuantity());
        }
    }
}