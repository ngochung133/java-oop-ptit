import java.util.*;
class nhanvien{
    String id;
    String name;
    long luongcoban;
    int ngay;
    String role;

    public nhanvien(String id, String name, long luongcoban, int ngay, String role){
        this.id = id;
        this.name = name;
        this.luongcoban = luongcoban;
        this.ngay = ngay;
        this.role = role;
    }
    long luong(){
        long total = this.luongcoban * this.ngay;
        return total;           
        }
    long thuong(){
        long a = luong();
        long thuong = 0;
        if(this.ngay >= 25){
            thuong = 20 * a / 100;
        }
        else if(this.ngay >= 22 && this.ngay < 25){
            thuong = 10 * a / 100;
        }
        return thuong;
    }
    int phucap(){
        if(this.role.equals("GD")){
            return 250000;
        }
        else if(this.role.equals("PGD")){
            return 200000;
        }
        else if(this.role.equals("TP")){
            return 180000;
        }
        else{
            return 150000;
        }
    }
}
    public class j04012{
        public static void main(String [] args){
            Scanner sc = new Scanner(System.in);
            String id = "NV01";
            String name = sc.nextLine();
            long luongcoban = Long.parseLong(sc.nextLine());
            int ngay = Integer.parseInt(sc.nextLine());
            String role = sc.nextLine();
            nhanvien nv = new nhanvien(id,name,luongcoban,ngay,role);
            long sum = nv.luong() + nv.thuong() + nv.phucap();
            System.out.printf("%s %s %d %d %d %d%n", nv.id, nv.name,nv.luong(), nv.thuong(),nv.phucap(),sum);
    }
}
