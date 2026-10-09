import java.util.*;
class Student{
    private String stt;
    private String id;
    private String name;
    private String lop;
    private String email;
    private String corp;
    public Student(String stt,String id,String name,String lop,String email,String corp){
        this.stt = stt;
        this.id = id;
        this.name = name;
        this.lop = lop;
        this.email = email;
        this.corp = corp;
    }
    public String getStt() {
        return stt;
    }
    public void setStt(String stt) {
        this.stt = stt;
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
    public String getCorp() {
        return corp;
    }
    public void setCorp(String corp) {
        this.corp = corp;
    }
}
public class j05035{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n= Integer.parseInt(sc.nextLine());
        HashMap<String , ArrayList<Student>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String stt = String.format("%1d", i+ 1);
            String id = sc.nextLine();
            String name = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            String corp = sc.nextLine();
            if(!map.containsKey(corp)){
                map.put(corp, new ArrayList<>());
            }
            map.get(corp).add(new Student(stt,id,name,lop,email,corp));
        }
        int Q = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < Q; i ++){
            String org = sc.nextLine();
            if(map.containsKey(org)){
                ArrayList<Student> list = map.get(org);
                list.sort(new Comparator<Student>(){
                    public int compare(Student a, Student b){
                        return a.getId().compareTo(b.getIdim());
                    }
                });
                for(Student sv : list){
                    System.out.printf("%s %s %s %s %s %s%n",sv.getStt(),sv.getId(),sv.getName(),sv.getLop(),sv.getEmail(),sv.getCorp());
                }
            }
        }
    }
}