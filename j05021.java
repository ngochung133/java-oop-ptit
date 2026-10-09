import java.util.*;
class SinhVien{
    private String id;
    private String name;
    private String lop;
    private String email;
    public SinhVien(String id, String name, String lop, String email){
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
public class j05021{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> a = new ArrayList<>();
        while(sc.hasNextLine()){
            String id = sc.nextLine();
            if(id.trim().isEmpty()){
                break;
            }
            String name = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            a.add(new SinhVien(id,name,lop,email));
        }
        a.sort(new Comparator<SinhVien>(){
            public int compare(SinhVien a, SinhVien b){
                return a.getId().compareTo(b.getId());
            }
        });
        for(SinhVien sv : a){
            System.out.printf("%s %s %s %s%n",sv.getId(),sv.getName(),sv.getLop(),sv.getEmail());
        }
    }
}