import java.util.*;
public class Sinhvien{
    String id;
    String name;
    String clas;
    String birth;
    double score;
    public Sinhvien(String id,String name, String clas,String birth,double score){
        this.id = id;
        this.name = name;
        this.clas = clas;
        this.birth = birth;
        this.score = score;
    }
    void chuanhoa(){
        String [] a = this.birth.split("/");
        String ngay = a[0];
        String thang = a[1];
        String nam = a[2];
        if(ngay.length() == 1){
            ngay = "0" + ngay;
        }
        if(thang.length() == 1){
            thang = "0" + thang;
        }
        this.birth = ngay + "/" + thang + "/" + nam;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String id = "B20DCCN001";
        String name = sc.nextLine();
        String clas = sc.nextLine();
        String birth = sc.nextLine();
        double score = Double.parseDouble(sc.nextLine());
        Sinhvien sv = new Sinhvien(id,name,clas,birth,score);
        sv.chuanhoa();
        System.out.printf("%s %s %s %s %.2f%n", sv.id, sv.name,sv.clas,sv.birth,sv.score);
    }
}