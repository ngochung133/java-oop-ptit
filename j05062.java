import java.util.*;

class Student{
    private String name;
    private double gpa;
    private int drl;
    private String status;
    public Student(String name, double gpa, int drl){
        this.name = name;
        this.gpa = gpa;
        this.drl = drl;
        this.status = cal_status(this.gpa, this.drl);
    }
    public String cal_status(double gpa, int drl){
        if(gpa >= 3.6 && drl >= 90){
            return "XUATSAC";
        }
        else if(gpa >= 3.2 && drl >= 80){
            return "GIOI";
        }
        else if(gpa >= 2.5 && drl >= 70){
            return "KHA";
        }
        else return "KHONG";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public int getDrl() {
        return drl;
    }
    public void setDrl(int drl) {
        this.drl = drl;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}

public class j05062{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<Student> list = new ArrayList<>();
        ArrayList<Student> hobo_list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String name = sc.nextLine(); 
            String line = sc.nextLine().trim();
            String [] arr = line.split("\\s+");
            double gpa = Double.parseDouble(arr[0]);
            int drl = Integer.parseInt(arr[1]);
            list.add(new Student(name, gpa, drl));
        }
        for(Student s : list){
            if(!s.getStatus().equals("KHONG")){
                hobo_list.add(s);
            }
        }
        Collections.sort(hobo_list, new Comparator<Student>(){
            public int compare(Student a, Student b){
                return Double.compare(b.getGpa(),a.getGpa());
            }
        });
       double minGpa = 0;
       if(!hobo_list.isEmpty()){
        if(m >= hobo_list.size()){
            minGpa = hobo_list.get(hobo_list.size() - 1).getGpa();
        }
        else{
            minGpa= hobo_list.get(m - 1).getGpa();
        }
       }
       for(Student st : list){
        if(st.getStatus().equals("KHONG") || st.getGpa() < minGpa){
            st.setStatus("KHONG");
        }
        System.out.printf("%s: %s%n", st.getName(),st.getStatus());
       }
       sc.close();
    }
}