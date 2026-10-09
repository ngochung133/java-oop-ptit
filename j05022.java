import java.util.*;
class SinhVien{
    private String id;
    private String name;
    private String lop;
    private String email;
    public SinhVien(String id, String name, String lop,String email){
        this.id = id;
        this.name = name;
        this.lop = lop;
        this.email = email;
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
    public String getLop() {
        return lop;
    }
    public void setLop(String lop) {
        this.lop = lop;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
public class j05022{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, ArrayList<SinhVien>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String id = sc.nextLine();
            String name = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            if(!map.containsKey(lop)){
                map.put(lop, new ArrayList<SinhVien>());
            }
            map.get(lop).add(new SinhVien(id,name,lop,email));
        }
        int Q = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < Q; i++){
            String querry = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN LOP " + querry + ":");
            if(map.containsKey(querry)){
                for(SinhVien sv : map.get(querry)){
                    System.out.printf("%s %s %s %s%n",sv.getId(),sv.getName(),sv.getLop(),sv.getEmail());
                }
            }
        }
    }
}