import java.util.*;
class svien{
    String id;
    String name;
    String lop;
    String birth;
    double gpa;
    public svien(){
        id = "";
        name = "";
        lop = "";
        birth = "";
        gpa = 0;
    }
    String chuanhoaten(){
        this.name = this.name.trim();
        this.name = this.name.toLowerCase();
        String ten = "";
        String [] word = this.name.split("\\s+");
        for(String x : word){
            ten += Character.toUpperCase(x.charAt(0)) + x.substring(1) + " ";
        }
        return ten.trim();
    }
    String chuanhoabirth(){
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
public class j05005{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        svien [] a = new svien[n];
        for(int i = 0; i < n; i++){
            svien sv = new svien();
            sv.id = String.format("B20DCCN%03d",i + 1);
            sv.name = sc.nextLine();
            sv.lop = sc.nextLine();
            sv.birth = sc.nextLine();
            sv.gpa = Double.parseDouble(sc.nextLine());
            sv.name = sv.chuanhoaten();
            sv.birth = sv.chuanhoabirth();
            a[i] = sv;
        }
        Arrays.sort(a, new Comparator<svien>() {
            public int compare(svien a, svien b) {
                return Double.compare(b.gpa, a.gpa);
            }
        });
        for(svien s : a){
            System.out.printf("%s %s %s %s %.2f%n", s.id, s.name,s.lop,s.birth,s.gpa);
        }
    }
}