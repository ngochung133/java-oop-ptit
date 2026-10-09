import java.util.*;
class Student{
    private String id;
    private String name;
    private String lop;
    private double diem1;
    private double diem2;
    private double diem3;
    public Student(String id,String name,String lop,double diem1, double diem2, double diem3){
        this.id = id;
        this.name = name;
        this.lop = lop;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
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
    public double getDiem1() {
        return diem1;
    }
    public void setDiem1(double diem1) {
        this.diem1 = diem1;
    }
    public double getDiem2() {
        return diem2;
    }
    public void setDiem2(double diem2) {
        this.diem2 = diem2;
    }
    public double getDiem3() {
        return diem3;
    }
    public void setDiem3(double diem3) {
        this.diem3 = diem3;
    }
}
public class j05031{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.nextLine();
            String name =sc.nextLine();
            String lop = sc.nextLine();
            double diem1 = Double.parseDouble(sc.nextLine());
            double diem2 = Double.parseDouble(sc.nextLine());
            double diem3 = Double.parseDouble(sc.nextLine());
            a.add(new Student(id,name,lop,diem1,diem2,diem3));
        }
        a.sort(new Comparator<Student>(){
            public int compare(Student a, Student  b){
                return a.getName().compareTo(b.getName());
            }
        });
        int stt = 1;
        for(Student st : a){
            System.out.printf("%d %s %s %s %.1f %.1f %.1f%n",stt,st.getId(),st.getName(),st.getLop(),st.getDiem1(),st.getDiem2(),st.getDiem3());
            stt += 1;
        }
    }
}