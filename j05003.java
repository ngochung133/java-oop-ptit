import java.util.*;
class svien{
    String id;
    String name;
    String lop;
    String birth;
    double gpa;
    public svien(String id, String name,String lop, String birth, double gpa){
        this.id = id;
        this.name = name;
        this.lop = lop;
        this.birth = birth;
        this.gpa = gpa;
    }
    String chuanhoa(){
        String [] a = this.birth.split("/");
        String ngay = a[0];
        String thang = a[1];
        String nam = a[2];
        if(ngay.length() < 2){
            ngay = "0" + ngay;
        }
        if(thang.length() < 2){
            thang = "0" + thang;
        }
        return this.birth = ngay + "/" + thang + "/" + nam;
    }
}
public class j05003{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            String id = String.format("B20DCCN%03d",i);
            String name = sc.nextLine();
            String lop = sc.nextLine();
            String birth = sc.nextLine();
            double gpa = Double.parseDouble(sc.nextLine());
            svien sv = new svien(id,name,lop,birth,gpa);
            System.out.printf("%s %s %s %s %.2f%n", sv.id, sv.name,sv.lop,sv.chuanhoa(),sv.gpa);
        }
    }
}