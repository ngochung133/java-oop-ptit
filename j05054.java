import java.util.*;
class Student{
    private String id;
    private String name;
    private double diem;
    private int rank;
    private String xeploai;
    public Student(int order, String name,double diem){
        this.id = String.format("HS%02d",order);
        this.name = name;
        this.diem = diem;
        this.xeploai= cal_xeploai(this.diem);
    }
    public String cal_xeploai(double a){
        if(a < 5){
            return "Yeu";
        }
        else if(a < 7){
            return "Trung Binh";
        }
        else if(a < 9){
            return "Kha";
        }
        else{
            return "Gioi";
        }
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
    public double getDiem() {
        return diem;
    }
    public void setDiem(double diem) {
        this.diem = diem;
    }
    public String getXeploai() {
        return xeploai;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public void setXeploai(String xeploai) {
        this.xeploai = xeploai;
    }
    public int getRank(){
        return rank;
    }
}
public class j05054{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String name = sc.nextLine();
            double diem = Double.parseDouble(sc.nextLine());
            arr.add(new Student(i,name,diem));
        }
        arr.sort(new Comparator<Student>(){
            public int compare(Student a, Student b){
                return Double.compare(b.getDiem(), a.getDiem());
            }
        });
            arr.get(0).setRank(1);
            for(int i = 1; i < n; i++){
                if(Double.compare(arr.get(i).getDiem(), arr.get(i - 1).getDiem()) == 0){
                    arr.get(i).setRank(arr.get(i - 1).getRank());
                }
                else{
                    arr.get(i).setRank(i + 1);
                }
            }
            arr.sort(new Comparator<Student>(){
                public int compare(Student a, Student b){
                    return a.getId().compareTo(b.getId());
                }
            });
            for(Student st : arr){
            System.out.printf("%s %s %.1f %s %d%n", st.getId(),st.getName(),st.getDiem(),st.getXeploai(),st.getRank());
        }
    }
}