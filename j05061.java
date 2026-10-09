import java.util.*;

class Worker{
    private String id;
    private String name;
    private String birth;
    private double theory;
    private double practice;
    private long avg;
    private String status;
    private long age;
    public Worker(int order, String name, String birth, double theory, double practice){
        this.id = String.format("PH%02d", order);
        this.name=  name;
        this.birth = birth;
        this.theory = theory;
        this.practice = practice;
        this.age = 2021 - Long.parseLong(birth.split("/")[2]);
        this.avg = cal_avg(this.theory, this.practice);
        this.status = cal_status(this.avg);
    }
    public long cal_avg(double a, double b){
        double reward = 0;
        if(a >= 8 && b >= 8){
            reward = 1;
        }
        else if(a >= 7.5 && b >= 7.5){
            reward = 0.5;
        }
        long sum = 0;
        sum =Math.round((a + b) / 2 + reward);
        if(sum >= 10){
            sum = 10;
        }
        return sum;
    }
    public String cal_status(long a){
        if(a >= 9) return "Xuat sac";
        else if(a >= 8) return "Gioi";
        else if(a >= 7) return "Kha";
        else if(a >= 5) return "Trung binh";
        else return "Truot";
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
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public double getTheory() {
        return theory;
    }
    public void setTheory(double theory) {
        this.theory = theory;
    }
    public double getPractice() {
        return practice;
    }
    public void setPractice(double practice) {
        this.practice = practice;
    }
    public long getAvg() {
        return avg;
    }
    public void setAvg(long avg) {
        this.avg = avg;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public long getAge() {
        return age;
    }
    public void setAge(long age) {
        this.age = age;
    }
    
    
}

public class j05061{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Worker> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String name = sc.nextLine();
            String birth = sc.nextLine();
            double theory = Double.parseDouble(sc.nextLine());
            double practice = Double.parseDouble(sc.nextLine());
            list.add(new Worker(i,name,birth,theory,practice));
        }
        Collections.sort(list, new Comparator<Worker>(){
            public int compare(Worker a, Worker b){
                if(a.getAvg() == b.getAvg()){
                    return a.getId().compareTo(b.getId());
                }
                return Long.compare(b.getAvg(),a.getAvg());
            }
        });
        for(Worker s : list){
            System.out.printf("%s %s %d %d %s%n", s.getId(),s.getName(), s.getAge(),s.getAvg(),s.getStatus());
        }
    }
}