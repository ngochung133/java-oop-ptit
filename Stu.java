import java.util.*;
public class Stu{
    String name;
    String birth;
    double diem1;
    double diem2;
    double diem3;
    public Stu(String name, String birth, double diem1, double diem2,double diem3){
        this.name = name;
        this.birth = birth;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }
    double aver(){
        return this.diem1 + this.diem2 + this.diem3;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String birth = sc.nextLine();
        double diem1 = sc.nextDouble();
        double diem2 = sc.nextDouble();
        double diem3 = sc.nextDouble();
        Stu sv = new Stu(name,birth,diem1,diem2,diem3);
        System.out.printf("%s %s %.1f%n", sv.name, sv.birth, sv.aver());
        sc.close();
    }
}