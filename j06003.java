import java.util.*;
class Student{
    private String id;
    private String name;
    private String phone;
    private int group;
    public Student(String id, String name,String phone,int group){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.group = group;
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getGroup() {
        return group;
    }
    public void setGroup(int group) {
        this.group = group;
    }
}
public class j06003{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, ArrayList<Student>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String id = sc.nextLine();
            String name = sc.nextLine();
            String phone = sc.nextLine();
            int group = Integer.parseInt(sc.nextLine());
            if(!map.containsKey(group)){
                map.put(group, new ArrayList<>());
            }
            map.get(group).add(new Student(id,name,phone,group));
        }
        String [] project = new String[m + 1];
        for(int i = 1; i <= m; i++){
            project[i] = sc.nextLine();
        }
        int Q = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= Q; i++){
            int querry = Integer.parseInt(sc.nextLine());
            System.out.println("DANH SACH NHOM " + querry + ":");
            if(map.containsKey(querry)){
                for(Student sv : map.get(querry)){
                    System.out.printf("%s %s %s%n",sv.getId(),sv.getName(),sv.getPhone());
                }
                System.out.println("Bai tap dang ky: " + project[querry]);
            }
        }
    }
}