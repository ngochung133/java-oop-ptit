import java.util.*;

class Student{
    private String id;
    private String name;
    // private double mathScore;
    // private double phyScore;
    // private double chemScore;   
    private double priPoint;
    private double sumScore;
    private String rank;
    public Student(String id, String name, double mathScore,double phyScore,double chemScore){
        this.id = id;
        this.name = name;
        // this.mathScore = mathScore;
        // this.phyScore = phyScore;
        // this.chemScore = chemScore;
        this.priPoint = cal_priPoint(this.id);
        this.sumScore = mathScore * 2 + phyScore + chemScore + this.priPoint;
    }
    String formatDouble(double a){
        if((int) a == a){
            return String.format("%d", (int) a);
        }
        return String.format("%.1f", a);
    }
    public double cal_priPoint(String s){
        String temp = s.substring(0,3);
        if(temp.equals("KV1")) return 0.5;
        else if(temp.equals("KV2")) return 1.0;
        else return 2.5;
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
    public double getPriPoint() {
        return priPoint;
    }
    public void setPriPoint(double priPoint) {
        this.priPoint = priPoint;
    }
    public double getSumScore() {
        return sumScore;
    }
    public void setSumScore(double sumScore) {
        this.sumScore = sumScore;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    
}
public class j05059{
    public static void main(String [] args ){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.nextLine();
            String name = sc.nextLine();
            double a = Double.parseDouble(sc.nextLine());
            double b = Double.parseDouble(sc.nextLine());
            double c = Double.parseDouble(sc.nextLine());
            list.add(new Student(id,name,a,b,c));
        }
        Collections.sort(list, new Comparator<Student>(){
            public int compare(Student a, Student b){
                if(a.getSumScore() == b.getSumScore()){
                    return a.getId().compareTo(b.getId());
                }
                return Double.compare(b.getSumScore(), a.getSumScore());
            }
        });
        int chitieu = Integer.parseInt(sc.nextLine());
        double benchmark = 0;
        if(chitieu < list.size()){
            benchmark = list.get(chitieu - 1).getSumScore();
        }
        else{
            benchmark = list.get(list.size() - 1).getSumScore();
        }
        System.out.printf("%.1f%n", benchmark);
        for(Student s : list){
            if(s.getSumScore() >= benchmark){
                s.setRank("TRUNG TUYEN");
            }
            else s.setRank("TRUOT");
            System.out.printf("%s %s %s %s %s%n",s.getId(),s.getName(),s.formatDouble(s.getPriPoint()),s.formatDouble(s.getSumScore()),s.getRank());
        }
        sc.close();
    }
}