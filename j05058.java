import java.util.*;

class Student{
    private double diemchuan = 24;
    private String id;
    private String name;
    private double mathScore;
    private double phyScore;
    private double chemScore;
    private double priPoint;
    private double Score;
    private double sumScore;
    public Student(String id, String name, double mathScore, double phyScore, double chemScore){
        this.id = id;
        this.name = name;
        this.mathScore = mathScore;
        this.phyScore = phyScore;
        this.chemScore = chemScore;
        this.Score = mathScore * 2 + phyScore + chemScore;
        this.priPoint = cal_priPoint(this.id);
        this.sumScore = this.priPoint + this.Score;
    }
    double cal_priPoint(String s){
        String code = s.substring(0,3);
        if(code.equals("KV1")) return 0.5;
        else if(code.equals("KV2")) return 1.0;
        else return 2.5;
    }
    String status(double a){
        if(a >= 24) return "TRUNG TUYEN";
        else return "TRUOT";    
    }
    String formatDouble(double a){
        if((int) a == a){
            return String.format("%d", (int) a);
        }
        return String.format("%.1f", a);
    }
    public double getDiemchuan() {
        return diemchuan;
    }
    public void setDiemchuan(double diemchuan) {
        this.diemchuan = diemchuan;
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
    public double getMathScore() {
        return mathScore;
    }
    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }
    public double getPhyScore() {
        return phyScore;
    }
    public void setPhyScore(double phyScore) {
        this.phyScore = phyScore;
    }
    public double getChemScore() {
        return chemScore;
    }
    public void setChemScore(double chemScore) {
        this.chemScore = chemScore;
    }
    public double getPriPoint() {
        return priPoint;
    }
    public void setPriPoint(double priPoint) {
        this.priPoint = priPoint;
    }
    public double getScore() {
        return Score;
    }
    public void setScore(double score) {
        Score = score;
    }
    public double getSumScore() {
        return sumScore;
    }
    public void setSumScore(double sumScore) {
        this.sumScore = sumScore;
    }
    
}
public class j05058{
    public static void main(String [] args){
        Scanner sc=  new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.nextLine();
            String name = sc.nextLine();
            double diem1 = Double.parseDouble(sc.nextLine());
            double diem2= Double.parseDouble(sc.nextLine());
            double diem3 = Double.parseDouble(sc.nextLine());
            list.add(new Student(id,name,diem1,diem2,diem3));
        }
        Collections.sort(list, new Comparator<Student>(){
            public int compare(Student a, Student b){
                if(a.getSumScore() == b.getSumScore()){
                    return a.getId().compareTo(b.getId());
                }
                return Double.compare(b.getSumScore(),a.getSumScore());
            }
        });
        

        for(Student s : list){
            System.out.printf("%s %s %s %s %s%n",s.getId(),s.getName(),s.formatDouble(s.getPriPoint()),s.formatDouble(s.getSumScore()),s.status(s.getSumScore()));
        }
        sc.close();
    }
}