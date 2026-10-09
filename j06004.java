import java.util.*;
class Student{
    private String id;
    private String name;
    private String phone;
    private int group;
    private String project;
    public Student(String id, String name,String phone, int group){
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
    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }
}
public class j06004{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<Student> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id =sc.nextLine();
            String name = sc.nextLine();
            String phone = sc.nextLine();
            int group = Integer.parseInt(sc.nextLine());
            a.add(new Student(id,name,phone,group));
        }
        String [] pro = new String[m + 1];
        for(int i = 1; i <= m; i++){
            pro[i] = sc.nextLine();
        }
        for(Student sv : a){
            sv.setProject(pro[sv.getGroup()]);
        }
        a.sort(new Comparator<Student>(){
            public int compare(Student a, Student b){
                return a.getId().compareTo(b.getId());
            }
        });
        for(Student st : a){
            System.out.printf("%s %s %s %d %s%n", st.getId(),st.getName(),st.getPhone(),st.getGroup(),st.getProject());
        }
    }
}